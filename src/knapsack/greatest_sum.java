package knapsack;

import java.util.Arrays;

public class greatest_sum {
    static int[][] dp;
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        if(n == 1){
            if(nums[0] % 3 != 0){
                return 0;
            }
            return nums[0];
        }
        dp = new int[n+1][3];

//        for(int[] row : dp){
//            Arrays.fill(row,-1);
//        }
//        int ans = solve(0,0,nums);
//
//        return ans < 0 ? 0 : ans;
        for(int[] row: dp){
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        dp[n][0] = 0;
        dp[n][1] = Integer.MIN_VALUE;
        dp[n][2] = Integer.MIN_VALUE;

        for(int i = n-1; i >= 0; i--){
            for(int rem = 0; rem <= 2; rem++){
                int newrem = ((rem + nums[i]) % 3);

                int take = dp[i+1][newrem] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[i+1][newrem] + nums[i];
                int skip = dp[i+1][rem];

                dp[i][rem] = Math.max(take,skip);

            }
        }
        return dp[0][0];
    }

//    public static int solve(int i, int rem, int[] nums){
//        if(i >= nums.length){
//            if(rem == 0){
//                return 0;
//            }
//            return Integer.MIN_VALUE;
//        }
//        if(dp[i][rem] != -1){
//            return dp[i][rem];
//        }
//
//        int takeNext = solve(i + 1, (rem + nums[i]) % 3, nums);
//        int take = Integer.MIN_VALUE;
//
//        if (takeNext != Integer.MIN_VALUE) {
//            take = nums[i] + takeNext;
//        }
//        int skip = solve(i+1,rem,nums);
//
//        return dp[i][rem] = Math.max(take,skip);
//    }
}
