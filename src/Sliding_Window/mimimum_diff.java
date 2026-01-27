package Sliding_Window;

import java.util.Arrays;

public class mimimum_diff {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int mindiff = Integer.MAX_VALUE;

        while(j < n){
            if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 == k){
                int max =  nums[j];
                int min = nums[i];
                mindiff = Math.min(mindiff,(max-min));
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return mindiff;
    }
}
