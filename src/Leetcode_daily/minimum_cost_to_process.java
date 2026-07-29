package Leetcode_daily;

import java.util.Arrays;

public class minimum_cost_to_process {
    static int MOD = 1_000_000_007;
    public int minimumCost(int[] nums, int k) {
        int n = nums.length;
        long resource = k;
        long opcount = 0;
        for(int i = 0; i < n; i++){
            if(resource < nums[i]){
                long needed = nums[i] - resource;
                long requiredOps = (needed + k - 1)/k;
                opcount += requiredOps;
                resource += (requiredOps * k);
            }
            resource -= nums[i];
        }
        long totalCost=  ((opcount % MOD) * ((opcount + 1) % MOD)) % MOD;
        totalCost = (totalCost * 500_000_004) % MOD;
        return (int) totalCost;
    }
}
