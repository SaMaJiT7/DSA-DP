package binary_search;

import java.util.Arrays;

public class maxFrequecy {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        int i = 0;
        int j = 0;
        int ans = 1;
        while(j < n){
            int target = nums[j];
            long windowsum  = prefix[j] - ((i > 0) ? prefix[i-1] : 0);
            long cost = ((long) target * (j-i+1)) - windowsum;
            if(cost > k) {
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }

        return ans;

    }
}
