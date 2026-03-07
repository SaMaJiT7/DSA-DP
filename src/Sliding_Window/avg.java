package Sliding_Window;

import java.util.Arrays;

public class avg {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        long sum = 0;
        int[] avg = new int[n];
        Arrays.fill(avg,-1);
        while(j < n){
            sum += nums[j];
            if(j-i+1 > 2*k+1){
                sum -= nums[i];
                i++;
            }
            if(j-i+1 == 2*k+1){
                int index = (j+i)/2;
                avg[index] = (int) (sum/(2*k+1));
            }
            j++;
        }
        return avg;
    }
}
