package LC_QUestion;

public class product_subarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int prefix  = 1;
        int suffix = 1;
        for(int i = 0; i < n; i++){
            prefix = prefix * nums[i];
            suffix = suffix * nums[n-i-1];

            max = Math.max(max, Math.max(prefix, suffix));

            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
        }
        return max;
    }
}
