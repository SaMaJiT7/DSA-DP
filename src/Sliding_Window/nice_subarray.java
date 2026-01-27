package Sliding_Window;

public class nice_subarray {
    public int numberOfSubarrays(int[] nums, int k) {
        int oddcount = 0;
        int prevcount = 0;
        int ans = 0;
        int n = nums.length;

        int i = 0;
        int j = 0;
        while(j < n){
            if(nums[j] % 2 != 0){
                oddcount++;
                prevcount = 0;
            }
            while(oddcount == k){
                prevcount++;
                if(nums[i] % 2 != 0){
                    oddcount--;
                }
                i++;
            }
            ans += prevcount;
            j++;
        }

        return ans;
    }
}
