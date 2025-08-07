package Sliding_Window;

public class variable_sizeK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int max = 0;

        while(j < n){
            sum = sum + nums[j];

            if(sum < k){
                j++;
            }
            else if(sum == k){
                max = Math.max(max,j-i+1);
                j++;
            }
            else if (sum > k) {
                while (sum > k && i <= j) {
                    sum = sum - nums[i];
                    i++;
                }
                if(sum == k){
                    max = Math.max(max, j - i + 1);
                }
                j++;
            }
        }
        return max;
    }
}
