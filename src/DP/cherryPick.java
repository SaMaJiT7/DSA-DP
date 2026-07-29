package DP;

public class cherryPick {
    Integer[][][] dp;
    int rows;
    int cols;
    public int cherryPickup(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.dp = new Integer[rows+1][cols+1][cols+1];
        return solve(0,0,cols-1,grid);
    }
    public int solve(int row, int c1,int c2,int[][] grid){
        if(c1 < 0 || c1 >= cols || c2 < 0 || c2 >= cols){
            return (int) -(1e9);
        }
        if(row >= rows){
            return 0;
        }
        if(dp[row][c1][c2] != null){
            return dp[row][c1][c2];
        }
        int currentCherries = (c1 == c2) ? grid[row][c1] : grid[row][c1]+grid[row][c2];
        int maxFutureCherries = (int) -(1e9);
        for(int d1 = -1; d1 <= 1; d1++){
            for(int d2 = -1; d2 <= 1; d2++){
                maxFutureCherries = Math.max(maxFutureCherries,solve(row+1,c1+d1,c2+d2,grid));
            }
        }

        return dp[row][c1][c2] = currentCherries + maxFutureCherries;
    }
}
