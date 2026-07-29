package DP;

public class maxAlternatingSum {
//    int n;
//    Long[][] dp;
//    public long maxAlternatingSum(int[] nums) {
//        this.n = nums.length;
//        this.dp = new Long[n+1][2];
//        return solve(nums,0,true);
//    }
//    public long solve(int[] nums,int idx,boolean isPositive){
//        if(idx >= n){
//            return 0;
//        }
//        int c = (isPositive ? 0 : 1);
//        if(dp[idx][c] != null){
//            return dp[idx][c];
//        }
//
//        long val = nums[idx];
//        if(!isPositive) {
//            val = -1 * val;
//        }
//        long take = val + solve(nums,idx+1,!isPositive);
//        long nottake = solve(nums,idx+1,isPositive);
//
//
//        return dp[idx][c] = Math.max(take,nottake);
//    }
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n+1][2];
        for(int i = 1; i <= n; i++){
            dp[i][0] = Math.max(dp[i-1][1]-nums[i-1],dp[i-1][0]); //even sequence
            dp[i][1] = Math.max(dp[i-1][0]+nums[i-1],dp[i-1][1]);
        }
        return Math.max(dp[n][1],dp[n][0]);
    }
}
