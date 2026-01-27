package binary_search;

public class smallest_divisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        int ans = 0;

        for(int i = 0; i < nums.length; i++){
            high = Math.max(high,nums[i]);
        }

        while(low <= high) {
            int sum = 0;
            int mid = low + (high-low)/2;

            for (int i = 0; i < nums.length; i++) {
                sum += (nums[i] + mid - 1) / mid;
            }

            if (sum <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
