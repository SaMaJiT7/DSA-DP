package Leetcode_daily;

public class make_strictly_increasing {
    public int minOperations(int[] nums) {
        int count = 0;
        int n = nums.length;
        if(n == 1) return 0;
        for(int i = 1; i < n; i++){
            if(nums[i-1] >= nums[i]){
                int diff = Math.abs(nums[i-1] - nums[i]) + 1;
                nums[i] = nums[i] + diff;
                count += diff;
            }
        }
        return count;
    }
}
