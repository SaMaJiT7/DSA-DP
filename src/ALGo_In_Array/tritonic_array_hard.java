package ALGo_In_Array;

import java.util.Arrays;

public class tritonic_array_hard {
    int n;
    long[][] memo;

    public long maxSumTrionic(int[] nums) {
        this.n = nums.length;
        this.memo = new long[n+1][4];
        for(long[] row : memo) {
            Arrays.fill(row, Long.MIN_VALUE);
        }
        return solve(0,0,nums);
    }
    public long solve(int i , int trend,int[] nums){
        if(i == n){
            if(trend == 3){
                return 0;
            }
            else{
                return Long.MIN_VALUE/2;
            }
        }

        if(memo[i][trend] != Long.MIN_VALUE){
            return memo[i][trend];
        }
        long take = Long.MIN_VALUE/2;
        long skip = Long.MIN_VALUE/2;
        if(trend == 0){
            skip = solve(i+1,0,nums);
        }
        if(trend == 3){
            take = nums[i];
        }
        if(i + 1 < n) {
            if (trend == 0 && nums[i] < nums[i + 1]) {
                take = Math.max(take,nums[i] + solve(i+1,1,nums));
            }
            else if(trend == 1){
                if(nums[i] < nums[i+1]){
                    take = Math.max(take,nums[i]+solve(i+1,1,nums));
                }
                else if(nums[i] > nums[i+1]){
                    take = Math.max(take,nums[i]+solve(i+1,2,nums));
                }
            }
            else if(trend == 2){
                if(nums[i] > nums[i+1]){
                    take = Math.max(take,nums[i] + solve(i+1,2,nums));
                }
                else if(nums[i] < nums[i+1]){
                    take = Math.max(take,nums[i]+solve(i+1,3,nums));
                }
            }
            else if(trend == 3 && nums[i] < nums[i+1]){
                take = Math.max(take,nums[i]+solve(i+1,3,nums));
            }
        }

        return memo[i][trend]  = Math.max(take,skip);
    }
}
