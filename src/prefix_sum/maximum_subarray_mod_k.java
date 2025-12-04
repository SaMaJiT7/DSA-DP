package prefix_sum;

public class maximum_subarray_mod_k {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        long maxsum = Long.MIN_VALUE;
        for(int start = 0; start < k; start++){
            long currsum = 0;
            int i = start;
            while(i < n && i+k-1 < n){
                int j = i + k - 1;
                long subsum = 0;

                if(i > 0){
                     subsum = prefix[j] - prefix[i-1];
                }
                else{
                     subsum = prefix[j] - 0;
                }

                currsum = Math.max(subsum,currsum+subsum);

                maxsum = Math.max(maxsum,currsum);

                i = i+k;
            }
        }
        return maxsum;
    }
}
