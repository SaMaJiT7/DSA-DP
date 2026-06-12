package Leetcode_daily;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class containsCycle {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,-1,1};
    int m ;
    int n;
    public boolean containsCycle(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(boolean[] row : visited) Arrays.fill(row,false);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
//                if(!visited[i][j] && dfs(i,j,visited,-1,-1,grid)){
//                    return true;
//                }
                if(!visited[i][j] && bfs(i,j,visited,grid)){
                    return true;
                }
            }
        }
        return false;
    }
//    public boolean dfs(int x,int y,boolean[][] visited,int parentrow,int parentcol,char[][] grid){
//        visited[x][y] = true;
//        char curr = grid[x][y];
//
//        for(int k = 0; k < 4; k++){
//            int nx = x + dx[k];
//            int ny = y + dy[k];
//
//            if(nx >= 0 && nx < m && ny >= 0 && ny < n){
//                if(grid[nx][ny] == curr) {
//                    if (nx == parentrow && ny == parentcol) continue;
//                    if (visited[nx][ny]) return true;
//
//                    if(dfs(nx,ny,visited,x,y,grid)){
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
    public boolean bfs(int i,int j,boolean[][] visited,char[][] grid){
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{i,j,-1,-1});
        visited[i][j] = true;
        char curr = grid[i][j];
        while(!que.isEmpty()){
            int[] val = que.poll();
            int x = val[0];
            int y = val[1];
            int parentrow = val[2];
            int parentcol = val[3];

            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (grid[nx][ny] == curr) {
                        if (!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            que.add(new int[]{nx, ny, x, y});
                        }
                        else if (nx == parentrow && ny == parentcol) {
                            continue;
                        }
                        else{
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
