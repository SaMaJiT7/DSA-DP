package graph;

import java.util.Arrays;

public class numIsLands {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    int m;
    int n;
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(boolean[] row : visited){
            Arrays.fill(row,false);
        }
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    ans += 1;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return ans;
    }
    public void dfs(int x,int y,char[][] grid,boolean[][] visited){
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (grid[nx][ny] == '1' && !visited[nx][ny]) {
                    dfs(nx,ny,grid,visited);
                }
            }
        }
    }
}
