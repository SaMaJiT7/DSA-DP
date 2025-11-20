package knapsack;

import java.util.Arrays;

public class ways_to_express {
//    static final int MOD = 1000000007;
//    public int numberOfWays(int n, int x) {
//        int maxBase = 1;
//        while (Math.pow(maxBase, x) <= n) maxBase++;
//
//        int[][] dp = new int[n + 1][maxBase + 2];
//        for (int[] row : dp) Arrays.fill(row, -1);
//
//        int ans = helper(n,x,1,dp);
//        return ans;
//    }
//    public int helper(int n , int x , int i,int[][] t){
//        if(n == 0){
//            return 1;
//        }
//        if(n < 0){
//            return 0;
//        }
//
//        int pow = (int) Math.pow(i,x);
//        if(pow > n){
//            return 0;
//        }
//
//        if(t[n][i] != -1){
//            return t[n][i];
//        }
//
//        int include = helper(n-pow,x,i+1,t);
//
//        int exclude = helper(n,x,i+1,t);
//
//        int result = (include + exclude) % MOD;
//
//        t[n][i] = result;
//
//        return result;
//    }

    static final int MOD = 1000000007;
    public static int numberOfWays(int n, int x) {
        int maxBase = 1;
        while (Math.pow(maxBase, x) <= n) maxBase++;

        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i = 1; i < maxBase; i++){
            int power = (int) Math.pow(i,x);

            for(int sum = n; sum >= power; sum--){
                dp[sum] = (dp[sum] + dp[sum - power]) % MOD;
            }
        }
        return dp[n];
    }
}
