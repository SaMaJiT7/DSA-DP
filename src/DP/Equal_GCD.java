package DP;

import java.util.HashMap;
import java.util.List;

public class Equal_GCD {
//    Integer[][][] dp;
//    static int MOD = 100_000_0007;
//    public int subsequencePairCount(int[] nums) {
//        int n = nums.length;
//        this.dp = new Integer[n+1][201][201];
//        return solve(nums,0,0,0);
//    }
//    private int solve(int[] nums,int i, int gcd1,int gcd2){
//        if(i == nums.length){
//            if(gcd1 > 0 && gcd1 == gcd2){
//                return 1;
//            }
//        }
//        if(dp[i][gcd1][gcd2] != null){
//            return dp[i][gcd1][gcd2];
//        }
//        long ways = solve(nums,i+1,gcd1,gcd2);
//
//        int takeseq1 = (gcd1 == 0) ? nums[i] : gcd(gcd1,nums[i]);
//        ways = (ways + solve(nums,i+1,takeseq1,gcd2)) % MOD;
//
//        int takeseq2 = (gcd2 == 0) ? nums[i] : gcd(gcd2,nums[i]);
//        ways = (ways + solve(nums,i+1,gcd1,takeseq2)) % MOD;
//
//        dp[i][gcd1][gcd2] = (int) ways;
//        return (int) ways;
//    }
    static int MOD = 1_000_000_007;
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max,nums[i]);
        }
        int[][][] dp = new int[n+1][max+1][max+1];
        for(int gcd1 = 0; gcd1 <= max; gcd1++){
            for(int gcd2 = 0; gcd2 <= max; gcd2++){
                boolean bothnotEmpty = (gcd1 != 0 && gcd2 != 0);
                boolean equal = (gcd1 == gcd2);
                dp[n][gcd1][gcd2] = (bothnotEmpty && equal) ? 1 : 0;
            }
        }
        for(int i = n-1; i >=0; i--){
            for(int gcd1 = max; gcd1 >= 0; gcd1--){
                for(int gcd2 = max; gcd2 >= 0; gcd2--){
                    long skip = dp[i+1][gcd1][gcd2];
                    long take1 = dp[i+1][gcd(gcd1,nums[i])][gcd2];
                    long take2 = dp[i+1][gcd1][gcd(gcd2,nums[i])];

                    dp[i][gcd1][gcd2] = (int)(skip + take1 + take2) % MOD;
                }
            }
        }
        return dp[0][0][0];
    }
    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
