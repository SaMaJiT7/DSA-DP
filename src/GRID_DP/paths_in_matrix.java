package GRID_DP;

import java.util.Arrays;
import java.util.jar.JarEntry;

public class paths_in_matrix {
    static int mod = 1000000007;
    static int[][][] t ;
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        t = new int[m+1][n+1][k+1];

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                Arrays.fill(t[i][j], 0);
            }
        }
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                Arrays.fill(t[i][j], -1);
//            }
//        }
        //Base Case:
        for(int rem = 0; rem <= k-1; rem++){
            t[m-1][n-1][rem] = (rem + grid[m-1][n-1]) % k == 0 ? 1 : 0;
        }
        for(int i = m-1; i >= 0; i--){
            for (int j = n-1; j >= 0; j--){
                for(int rem = 0; rem < k; rem++){
                    if(i == m-1 && j == n-1) continue;
                    int R = (rem + grid[i][j]) % k;
                    int down = t[i+1][j][R];
                    int right = t[i][j+1][R];

                    t[i][j][rem] = (down+right)%mod;
                }
            }
        }
//        int ans = solve(0,0,grid,k,0);
//        return ans;
        return t[0][0][0];
    }
//    public static int solve(int i, int j, int[][] grid,int k,int currsum){
//        int m = grid.length;
//        int n = grid[0].length;
//        if(i >= m || j >= n){
//            return 0;
//        }
//        if(i == m-1 && j == n-1){
//            return ((currsum + grid[i][j]) % k == 0) ? 1 : 0;
//        }
//        if(t[i][j][currsum] != -1){
//            return t[i][j][currsum];
//        }
//
//        int down = solve(i+1,j,grid,k,(currsum+grid[i][j]) % k);
//        int right = solve(i,j+1,grid,k,(currsum + grid[i][j]) % k);
//
//        return t[i][j][currsum] = (down+right) % mod;
//    }
}
