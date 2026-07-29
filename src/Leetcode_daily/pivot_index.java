package Leetcode_daily;

public class pivot_index {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixsum = new int[n];
        prefixsum[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefixsum[i] = prefixsum[i-1] + nums[i];
        }
        for(int i = 0; i < n; i++){
            int left = (i-1 > 0) ? prefixsum[i-1] : 0;
            int right = prefixsum[n-1] - prefixsum[i];

            if(left == right){
                return i;
            }
        }
        return -1;
    }
}
