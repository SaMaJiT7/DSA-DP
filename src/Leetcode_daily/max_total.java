package Leetcode_daily;

public class max_total {
    public long maxTotalValue(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int mx = nums[i];
            int mn = nums[i];

            for(int j = i; j < n; j++){
                mx = Math.max(mx,nums[j]);
                mn = Math.min(mn,nums[j]);


                int value = mx - mn;
                max = Math.max(value,max);
            }
        }
        return (k * max);
    }
}
