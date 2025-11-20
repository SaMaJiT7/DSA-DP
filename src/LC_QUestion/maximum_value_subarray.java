package LC_QUestion;

public class maximum_value_subarray {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        for(int i = 1; i < n;i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        int diff = max - min;
        return (diff * k);
    }
}
