package knapsack;

import java.util.Arrays;
import java.util.List;

public class triangle {
    static int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row,0);
        }

        for (int j=0; j<n; j++) {
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int downright = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(downright,down);
            }
        }
        return dp[0][0];
    }


//    public int minimumTotal2(List<List<Integer>> triangle) {
//        int n = triangle.size();
//        dp = new int[n];
//        if(n == 0){
//            return 0;
//        }
//        for (int j=0; j<n; j++) {
//            dp[j] = triangle.get(n-1).get(j);
//        }
//
//        for(int i = n-2; i >= 0; i--){
//            for(int j = 0; j <= i; j++){
//                dp[j] = triangle.get(i).get(j) + Math.min(dp[j],dp[j+1]);
//            }
//        }
//        return dp[0];
//    }
public int minimumTotal5(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[] dp = new int[n];
    int[] curr = new int[n];
    for(int row : dp){
        row = 0;
    }
    for(int i = 0; i < n; i++){
        curr[i] = 0;
    }

    for (int j=0; j<n; j++) {
        dp[j] = triangle.get(n-1).get(j);
    }

    for(int i = n-2; i >= 0; i--){
        for(int j = 0; j <= i; j++){
            int down = triangle.get(i).get(j) + dp[j];
            int downright = triangle.get(i).get(j) + dp[j+1];
            curr[j] = Math.min(downright,down);
        }
        dp = curr;
    }
    return dp[0];
}
}
