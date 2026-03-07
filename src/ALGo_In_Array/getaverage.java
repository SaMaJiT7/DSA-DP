package ALGo_In_Array;

import java.util.Arrays;

public class getaverage {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] avg = new int[n];
        Arrays.fill(avg,-1);
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        for(int i = 0; i < n; i++){
            if(i-k >= 0 && i+k < n){
                long sum = prefix[i+k] - (i-k-1 >= 0 ? prefix[i-k-1] : 0);
                avg[i] = (int)(sum / (2*k + 1));
            }
        }
        return avg;
    }
}
