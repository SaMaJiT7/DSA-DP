package graph;

import java.util.Arrays;

public class noofislands {
    boolean[][] visited;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,-1,1};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        this.visited = new boolean[n][m];
        for(boolean[] row : visited){
            Arrays.fill(row,false);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    ans += 1;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid, int r, int c){
        int n = grid.length;
        int m = grid[0].length;
        visited[r][c] = true;
        for(int i = 0; i < 4; i++){
            int newR = r + dx[i];
            int newC = c + dy[i];
            if(newR < n && newR >= 0 && newC < m && newC >=0) {
                if (grid[newR][newC] == '1' && !visited[newR][newC]) {
                    dfs(grid, newR, newC);
                }
            }
        }
    }
}
