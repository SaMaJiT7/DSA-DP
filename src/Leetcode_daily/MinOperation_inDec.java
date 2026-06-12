package Leetcode_daily;

public class MinOperation_inDec {
    public long minOperations(int[] nums) {
        int n = nums.length;
        long ops = 0;
        for(int i = 1; i < n; i++){
            if(nums[i-1] > nums[i]){
                ops += (nums[i-1]-nums[i]);
            }
        }
        return ops;
    }
}
