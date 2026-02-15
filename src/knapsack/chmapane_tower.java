package knapsack;

import java.util.Arrays;

public class chmapane_tower {
//    int poured;
//    double[][] memo = new double[101][101];
//    public double champagneTower(int poured, int query_row, int query_glass) {
//        double ans = 0;
//        this.poured = poured;
//        for(int i = 0; i < 101; i++){
//            for(int j = 0; j < 101; j++){
//                memo[i][j] = -1;
//            }
//        }
//        ans = Math.min(1.0,solve(query_row,query_glass));
//        return ans;
//    }
//    public double solve(int i , int j){
//        if(i < 0 || j < 0 || i > j){
//            return 0.0;
//        }
//        if(i == 0 && j == 0){
//            return memo[i][j] = poured;
//        }
//        if(memo[i][j] != -1){
//            return memo[i][j];
//        }
//        double left_up = (solve(i-1,j-1)-1)/2.0;
//        double right_up = (solve(i-1,j)-1)/2.0;
//        if(left_up < 0) left_up = 0.0;
//        if(right_up < 0) right_up = 0.0;
//        return memo[i][j] = left_up+right_up;
//    }


    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        dp[0][0] = (double) poured;

        for(int row = 0; row <= query_row; row++){
            for(int col = 0; col <= row; col++){

                double excess = (dp[row][col] - 1.0)/2.0;

                if(excess > 0){
                    dp[row+1][col] += excess;
                    dp[row+1][col+1] += excess;

                }
            }
        }
        return Math.min(1.0,dp[query_row][query_glass]);
    }
}
