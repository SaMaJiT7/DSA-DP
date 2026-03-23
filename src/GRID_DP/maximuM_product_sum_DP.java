package GRID_DP;

import java.util.Arrays;

public class maximuM_product_sum_DP {
    int m;
    int n;
    static int MOD = 1000000007;
    long[][] maxDp;
    long[][] minDp;
    public int maxProductPath(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.maxDp = new long[m][n];
        this.minDp = new long[m][n];
        for(long[] row : maxDp){
            Arrays.fill(row,Long.MIN_VALUE);
        }
        for(long[] row : minDp){
            Arrays.fill(row,Long.MAX_VALUE);
        }
        long[] ans = solve(0,0,grid);
        if(ans[0] < 0){
            return -1;
        }
        return (int)(ans[0] % MOD);
    }
    public long[] solve(int i, int j, int[][] grid){
        if(i == m-1 && j == n-1){
            return new long[]{grid[i][j],grid[i][j]};
        }

        long minval = Long.MAX_VALUE;
        long maxval = Long.MIN_VALUE;
        if(maxDp[i][j] != Long.MIN_VALUE && minDp[i][j] != Long.MAX_VALUE){
            return new long[]{maxDp[i][j],minDp[i][j]};
        }
        //DOWN
        if(i+1 < m){
            long[] val = solve(i+1,j,grid);
            long downmax = val[0];
            long downmin = val[1];

            maxval = Math.max(maxval,Math.max(grid[i][j] * downmax,grid[i][j] * downmin));
            minval = Math.min(minval,Math.min(grid[i][j] * downmax,grid[i][j] * downmin));
        }

        //Right
        if(j+1 < n){
            long[] val = solve(i,j+1,grid);
            long rightmax = val[0];
            long rightmin = val[1];

            maxval = Math.max(maxval,Math.max(grid[i][j] * rightmax,grid[i][j] * rightmin));
            minval = Math.min(minval,Math.min(grid[i][j] * rightmax,grid[i][j] * rightmin));
        }
        maxDp[i][j] = maxval;
        minDp[i][j] = minval;
        return new long[]{maxval,minval};
    }
}
