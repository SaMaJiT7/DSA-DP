package GRID_DP;

public class Minimum_path_sum {
    static int[][] t;
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        t = new int[n][m];

        t[0][0] = grid[0][0];

        for(int i = 1; i < n; i++){
            t[i][0] = t[i-1][0] + grid[i][0];
        }

        for(int j = 1; j < m; j++){
            t[0][j] = t[0][j-1] + grid[0][j];
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                t[i][j] = grid[i][j] + Math.min(t[i-1][j],t[i][j-1]);
            }
        }
        return t[n-1][m-1];
    }
}
