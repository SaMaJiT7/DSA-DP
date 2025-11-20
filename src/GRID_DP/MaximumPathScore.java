package GRID_DP;

import java.util.Arrays;

public class MaximumPathScore {
    static int[][][] dp = new int[201][201][1001];
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m][k+1];
        for (int[][] layer : dp)
            for (int[] row : layer)
                Arrays.fill(row, Integer.MIN_VALUE / 2);

        dp[0][0][(grid[0][0] > 0 ? 1 : 0)] = grid[0][0];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0) continue;
                for(int c = 0; c <= k; c++){
                    if(i > 0 && c-Math.min(grid[i][j],1) >= 0){
                        dp[i][j][c] = Math.max(dp[i][j][c],dp[i-1][j][c-Math.min(grid[i][j],1)] + grid[i][j]);
                    }
                    if(j > 0 && c-Math.min(grid[i][j],1) >= 0){
                        dp[i][j][c] = Math.max(dp[i][j][c],dp[i][j-1][c-Math.min(grid[i][j],1)] + grid[i][j]);
                    }
                }
            }
        }
        int ans = -1;
        for(int c = 0; c <= k; c++){
            ans = Math.max(ans,dp[n-1][m-1][c]);
        }
        return ans;
    }
}
