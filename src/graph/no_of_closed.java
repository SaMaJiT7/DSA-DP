package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class no_of_closed {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,-1,1};
    int n;
    int m;
    boolean[][] visited;
    public int closedIsland(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        visited = new boolean[n][m];
        for(boolean[] rows : visited){
            Arrays.fill(rows,false);
        }
        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    if(bfs(i,j,grid,visited)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public boolean bfs(int i, int j, int[][] grid,boolean[][] visited){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i,j});
        visited[i][j] = true;

        boolean isclosed = true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            int x = curr[0];
            int y = curr[1];

            if((x == 0 || x == n-1 || y == 0 || y == m-1)&& grid[x][y] == 0){
                isclosed = false;
            }

            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(checksafe(nx,ny,grid)){
                    if(grid[nx][ny] == 0 && !visited[nx][ny]){
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return isclosed;
    }

    public boolean checksafe(int i, int j , int[][] grid){
        return(i >= 0 && i < n && j >= 0 && j < m);
    }
}
