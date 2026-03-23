package Leetcode_daily;

public class arthemic_array {
    public int longestArithmetic(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n-1];
        for(int i = 0; i < n; i++){
            diff[i] = nums[i+1] - nums[i];
        }
        // left[i] = length of equal-diff streak ending at diff[i]
        int[] left = new int[n - 1];
        left[0] = 1;
        for (int i = 1; i < n - 1; i++) {
            if (diff[i] == diff[i - 1]) left[i] = left[i - 1] + 1;
            else left[i] = 1;
        }

        // right[i] = length of equal-diff streak starting at diff[i]
        int[] right = new int[n - 1];
        right[n - 2] = 1;
        for (int i = n - 3; i >= 0; i--) {
            if (diff[i] == diff[i + 1]) right[i] = right[i + 1] + 1;
            else right[i] = 1;
        }

        int ans = 2;

        // No-change arithmetic subarray also counts
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, left[i] + 1);
        }

        for (int k = 0; k < n; k++) {
            int cur = 1;

            // change at boundary
            if (k == 0) {
                cur = 1 + right[1 >= n - 1 ? 0 : 0];
                ans = Math.max(ans, Math.min(n, cur + 1));
                continue;
            }
            if (k == n - 1) {
                cur = 1 + left[n - 2];
                ans = Math.max(ans, cur);
                continue;
            }

            // Try to merge through k
            int sum = nums[k - 1] + nums[k + 1];
            if (sum % 2 == 0) {
                int d = (nums[k + 1] - nums[k - 1]) / 2;

                int lenLeft = 1;   // nums[k-1] included
                int lenRight = 1;  // nums[k+1] included

                if (k - 2 >= 0 && diff[k - 2] == d) {
                    lenLeft += left[k - 2];
                }
                if (k + 1 <= n - 2 && diff[k + 1] == d) {
                    lenRight += right[k + 1];
                }

                cur = lenLeft + 1 + lenRight; // changed nums[k]
                ans = Math.max(ans, cur);
            }

            // Also possible to extend only one side
            ans = Math.max(ans, 2 + (k - 2 >= 0 ? left[k - 2] : 0));
            ans = Math.max(ans, 2 + (k + 1 <= n - 2 ? right[k + 1] : 0));
        }

        return ans;
    }
}
