package graph;

import java.util.Arrays;

public class minimum_cost_with_telepotations {
    int[][] grid;
    int m,n,k;

//    public int minCost(int[][] grid, int k) {
//        this.m = grid.length;
//        this.n = grid[0].length;
//        this.k = k;
//        this.grid = grid;
//        this.dp = new int[m][n][k+1];
//        for(int i = 0; i  < m; i++){
//            for(int j = 0; j < n; j++){
//                Arrays.fill(dp[i][j],-1);
//            }
//        }
//        int ans = helper(0,0,0);
//        return ans;
//    }
//    public int helper(int i, int j, int t){
//        int mincost = Integer.MAX_VALUE;
//
//        if(i == m-1 && j == n-1){
//            return grid[i][j];
//        }
//
//        if(dp[i][j][t] != -1){
//            return dp[i][j][t];
//        }
//
//        if(i+1 < m) mincost = Math.min(mincost,grid[i+1][j] + helper(i+1,j,t));
//
//        if(j+1 < n) mincost = Math.min(mincost,grid[i][j+1] + helper(i,j+1,t));
//
//        if(t < k){
//            for(int x = 0; x < m; x++){
//                for(int y = 0; y < n; y++){
//                    if(grid[x][y] <= grid[i][j] && (x != i || y != j)){
//                        mincost = Math.min(mincost,0+helper(x,y,t+1));
//                    }
//                }
//            }
//        }
//        return dp[i][j][t] = mincost;
//    }

    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        final int INF = (int) 1e9;

        int[][] prev = new int[m][n];
        int[][] dp = new int[m][n];

        for (int[] row : prev) Arrays.fill(row, INF);
        prev[m - 1][n - 1] = grid[m - 1][n - 1];

        int maxVal = 0;
        for (int[] row : grid) {
            for (int v : row) maxVal = Math.max(maxVal, v);
        }

        int[] teleport = new int[maxVal + 1];

        for (int t = 0; t <= k; t++) {

            Arrays.fill(teleport, INF);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    teleport[grid[i][j]] =
                            Math.min(teleport[grid[i][j]], prev[i][j]);
                }
            }


            for (int i = 1; i <= maxVal; i++) {
                teleport[i] = Math.min(teleport[i], teleport[i - 1]);
            }

            for (int[] row : dp) Arrays.fill(row, INF);


            dp[m - 1][n - 1] = grid[m - 1][n - 1];
            if (t > 0) {
                dp[m - 1][n - 1] =
                        Math.min(dp[m - 1][n - 1],
                                teleport[grid[m - 1][n - 1]]);
            }

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {

                    if (i + 1 < m) {
                        dp[i][j] =
                                Math.min(dp[i][j],
                                        grid[i+1][j] + dp[i + 1][j]);
                    }
                    if (j + 1 < n) {
                        dp[i][j] =
                                Math.min(dp[i][j],
                                        grid[i][j+1] + dp[i][j + 1]);
                    }

                    if (t > 0) {
                        dp[i][j] =
                                Math.min(dp[i][j],
                                        teleport[grid[i][j]]);
                    }
                }
            }

            int[][] temp = prev;
            prev = dp;
            dp = temp;
        }

        return prev[0][0];
    }
}
