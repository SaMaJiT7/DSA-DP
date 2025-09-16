package prefix_sum;

public class no_of_ways {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        int partition = 0;
        long[] prefixfront = new long[n];


        prefixfront[0] = nums[0];


        for(int i = 1; i < n ; i++){
            prefixfront[i] = prefixfront[i-1] + nums[i];
        }

        long total = prefixfront[n-1];

        for(int i = 0; i < n-1; i++){
            long left = prefixfront[i];
            long right = total - left;
            if(left >= right) {
                partition = partition + 1;
            }
        }
        return partition;
    }
}
