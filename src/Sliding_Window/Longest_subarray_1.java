package Sliding_Window;

public class Longest_subarray_1 {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int total = Integer.MIN_VALUE;
        int count = 0;

        while(j < n){
            if(nums[j] == 1){
                j++;
            }
            else if (nums[j] == 0){
                count = count +1;
                j++;
            }
            while (count > 1 && i < j) {
                if (nums[i] == 0) {
                   count--;
                }
                i++;
            }
            total = Math.max(total,j-i);
        }
        return total;
    }
}
