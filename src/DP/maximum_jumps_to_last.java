package DP;

import java.util.Arrays;

public class maximum_jumps_to_last {
    int[] dp;
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        this.dp = new int[n];
        Arrays.fill(dp,-1);
        dp[n-1] = 0;

        for(int i = n-2; i >= 0; i--){
            for(int j = i+1; j < n; j++) {
                int val = nums[j] - nums[i];
                if (val >= -(target) && val <= target) {
                    if (dp[j] != -1) {
                        dp[i] = Math.max(dp[i], 1 + dp[j]);
                    }
                }
            }
        }
        return dp[0];
    }

//    public int solve(int i,int n,int[] nums,int target){
//        if(i == n-1){
//            return 0;
//        }
//        if(t[i] != -1){
//            return t[i];
//        }
//        int take = Integer.MIN_VALUE;
//        for(int j = i+1; j < n; j++){
//            int val = nums[j]-nums[i];
//            if(val >= -(target) && val <= target){
//                int call = solve(j,n,nums,target);
//                if(call!= -1) {
//                    take = Math.max(take, 1+call);
//                }
//            }
//        }
//        return t[i] = take;
//    }
}
