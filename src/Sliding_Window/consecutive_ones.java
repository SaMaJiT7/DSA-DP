package Sliding_Window;

public class consecutive_ones {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int no_zero = 0;
        int max = 0;

        while(j < n){
            if(nums[j] == 0){
                no_zero += 1;
            }

            if(no_zero == k){
                max = Math.max(max,j-i+1);
                j++;
            }
            else if (no_zero > k) {
                while (no_zero > k && i <= j) {
                    if(nums[i] == 0){
                        no_zero -= 1;
                    }
                    i++;
                }
                if(no_zero == k){
                    max = Math.max(max, j - i + 1);
                }
                j++;
            }
        }
        return max;
    }
}
