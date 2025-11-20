package GRID_DP;

import java.util.Arrays;

public class unique_path {
    static int[][] t = new int[101][101];
//    public int uniquePaths(int m, int n) {
//        t[0][0] = 1 ;
//
//
//        for(int i = 0; i < m; i++){
//            for (int j = 0; j < n; j++){
//                if(i == 0 && j == 0){
//                    t[i][j] = 1;
//                }
//                else{
//                    int up = 0;
//                    int left = 0;
//                    if(i > 0){
//                        up = t[i-1][j];
//                    }
//                    if(j > 0){
//                        left = t[i][j-1];
//                    }
//                    t[i][j] = up+left;
//                }
//            }
//        }
//        return t[m-1][n-1];
//    }

//    static int helper(int i , int j){
//        if(i <= 0 && j <= 0 ){
//            return 1;
//        }
//        if(i < 0 || j < 0){
//            return 0;
//        }
//        if(t[i][j] != -1){
//            return t[i][j];
//        }
//
//        int up = helper(i-1,j);
//        int left = helper(i,j-1);
//
//        return t[i][j] = up+left;
//    }
public int uniquePaths(int m, int n) {
    int[] dp = new int[n];
    Arrays.fill(dp,0);

    for(int i = 0; i < m; i++){
        int[] temp = new int[n];
        for (int j = 0; j < n; j++){
            if(i == 0 && j == 0){
                temp[j] = 1;
            }
            else{
                int left = (j > 0) ? temp[j-1] : 0;
                int up = (i > 0) ? dp[j] : 0;
                temp[j] = up + left;
            }
        }
        dp = temp;
    }
    return dp[n-1];
}
}
