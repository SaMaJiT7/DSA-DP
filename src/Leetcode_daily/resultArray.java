package Leetcode_daily;

public class resultArray {
    public long[] resultArray(int[] nums, int k) {
        long[] dp = new long[k];
        long[] answer = new long[k];
        int n = nums.length;
        for(int i = 0; i < n; i++){
            long[] new_dp = new long[k];
            int current_element = nums[i] % k;
            for(int rem = 0; rem < k; rem++){
                if(dp[rem] > 0) {
                    int new_rem = (rem * current_element) % k;

                    new_dp[new_rem] += dp[rem];
                }
            }
            new_dp[current_element]++;

            for(int rem = 0; rem < k; rem++){
                answer[rem] += new_dp[rem];
            }

            System.arraycopy(new_dp,0,dp,0,new_dp.length);
        }
        return answer;
    }
}
