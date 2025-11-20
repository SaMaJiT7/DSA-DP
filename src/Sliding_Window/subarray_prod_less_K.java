package Sliding_Window;

public class subarray_prod_less_K {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int prod = 1;
        int i = 0;
        int j = 0;

        if(k <= 1){
            return 0;
        }
        while(i <= j){
            prod = prod * nums[j];

            if(prod < k){
                count += 1;
            }
            else if(prod > k){
                while(prod > k){
                    i++;
                }
                prod = 1;
            }
            j++;
        }
        return count;
    }
}
