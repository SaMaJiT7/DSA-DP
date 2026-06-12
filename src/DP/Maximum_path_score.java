package DP;

import java.util.Arrays;

public class Maximum_path_score {
    int[][][] t;
    int m;
    int n;
//    public int maxPathScore(int[][] grid, int k) {
//        this.m = grid.length;
//        this.n = grid[0].length;
//        this.t = new int[m+1][n+1][k+1];
//
//        for(int[][] rows : t){
//            for(int[] vals : rows){
//                Arrays.fill(vals,-1);
//            }
//        }
//        int score = solve(0,0,k,grid,0);
//        return (score == Integer.MIN_VALUE ? -1 : score);
//    }
//    public int solve(int i, int j, int k, int[][] grid,int cost){
//        if (i >= m || j >= n) return Integer.MIN_VALUE;
//
//
//        int newcost = cost + (grid[i][j] == 0 ? 0 : 1);
//        if(newcost > k){
//           return Integer.MIN_VALUE;
//        }
//        if(i == m-1 && j == n-1){
//            return grid[i][j];
//        }
//        if(t[i][j][cost] != -1){
//            return t[i][j][cost];
//        }
//        int right = solve(i,j+1,k,grid,newcost);
//        int down = solve(i+1,j,k,grid,newcost);
//
//        if(right == Integer.MIN_VALUE && down == Integer.MIN_VALUE) return t[i][j][cost] = Integer.MIN_VALUE;
//
//        return t[i][j][cost] = grid[i][j] + Math.max(right,down);
//    }
    int[][][] dp;
    public int maxPathScore(int[][] grid, int k) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.dp = new int[m+1][n+1][k+1];
        for(int[][] layers : dp){
            for(int[] row : layers){
                Arrays.fill(row,Integer.MIN_VALUE/2);
            }
        }
        dp[0][0][(grid[0][0] > 0 ? 1 : 0)] = grid[0][0];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) continue;
                for(int c = 0; c <= k ; c++){
                    if(i > 0 && c-Math.min(grid[i][j],1) >= 0){
                        dp[i][j][c] = Math.max(dp[i][j][c],dp[i-1][j][c-Math.min(grid[i][j],1)] + grid[i][j]);
                    }
                    if(j > 0 && c-Math.min(grid[i][j],1) >= 0){
                        dp[i][j][c] =  Math.max(dp[i][j][c],dp[i][j-1][c-Math.min(grid[i][j],1)] + grid[i][j]);
                    }
                }
            }
        }

        int ans = -1;
        for(int c = 0; c <= k; c++) ans = Math.max(ans,dp[m-1][n-1][c]);

        return ans;
    }
}
