package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class no_of_encalves {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,-1,1};
    int n;
    int m;
    public int numEnclaves(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        int ans = 0;
        if(n == 1 && m == 1 && grid[0][0] == 0) return 0;
        //Top row
        for(int j = 0; j < m; j++){
            if(grid[0][j] == 1) bfs(grid,0,j);
        }
        //Bottom Row
        for(int j = 0; j < m; j++){
            if(grid[n-1][j] == 1) bfs(grid,n-1,j);
        }

        // First Column
        // First Column
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1) bfs(grid,i,0);
        }
        // Last Column
        for(int i = 0; i < n; i++){
            if(grid[i][m-1] == 1) bfs(grid,i,m-1);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }
    public void bfs(int[][] grid,int i, int j){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{i,j});
        grid[i][j] = 0;

        while(!que.isEmpty()){
            int[] curr = que.poll();
            int x = curr[0];
            int y = curr[1];

            for(int k = 0; k < 4; k++){
                int newX = x + dx[k];
                int newY = y + dy[k];

                if(checkSafe(newX,newY)){
                    if(grid[newX][newY] == 1){
                       que.add(new int[]{newX,newY});
                       grid[newX][newY] = 0;
                    }
                }
            }
        }
    }
    public boolean checkSafe(int newx, int newy){
        return (newx >= 0 && newx < n && newy >= 0 && newy < m);
    }
}
