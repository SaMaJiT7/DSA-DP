package LC_QUestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class compute_decimal {
    public int[] decimalRepresentation(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 0) {
            return new int[0]; // Special case for 0
        }
        int power = 0;
        while (n > 0) {
            long digit = n % 10;
            if (digit != 0) {
                int value = (int) (digit * Math.pow(10, power));
                result.add(value);
            }
            n /= 10;
            power++;
        }
        Collections.reverse(result); // Order from highest to lowest power
        return result.stream().mapToInt(i -> i).toArray();
    }

    public long splitArray(int[] nums) {
        int n = nums.length;
        if(n <= 1){
            return 0;
        }
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
        long mindiff = Long.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            boolean leftIncreasing = isStrictlyIncreasing(nums, 0, i - 1);
            boolean rightDecreasing = isStrictlyDecreasing(nums, i, n - 1);
            if (leftIncreasing && rightDecreasing) {
                int leftSum = prefix[i];
                int rightSum = prefix[n] - prefix[i];
                int diff = Math.abs(leftSum - rightSum);
                if (diff < mindiff) {
                    mindiff = diff;
                }
            }
        }
        return (mindiff == Integer.MAX_VALUE) ? -1 : mindiff;
    }
    private static boolean isStrictlyIncreasing(int[] sub, int start, int end) {
        for (int i = start; i < end; i++) {
            if (sub[i] >= sub[i + 1]) {
                return false;
            }
        }
        return true;
    }


    private static boolean isStrictlyDecreasing(int[] sub, int start, int end) {
        for (int i = start; i < end; i++) {
            if (sub[i] <= sub[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
