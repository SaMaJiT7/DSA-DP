package number_theory;

import java.util.HashMap;
import java.util.Map;

public class minimum_to_one_gcd {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ops = 0;
        int noofones = 0;
        for(int num : nums){
            if(num == 1){
                noofones++;
            }
        }

        if(noofones > 0){
            return n - noofones;
        }

        int minLen = Integer.MAX_VALUE;

        // Store current possible gcds and their minimal subarray length
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> next = new HashMap<>();
            next.put(nums[i], 1); // single element

            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                int g = gcd(e.getKey(), nums[i]);
                int len = e.getValue() + 1;
                next.put(g, Math.min(next.getOrDefault(g, Integer.MAX_VALUE), len));
            }

            map = next;
            if (map.containsKey(1)) {
                minLen = Math.min(minLen, map.get(1));
            }
        }

        if (minLen == Integer.MAX_VALUE) return -1;
        return (minLen - 1) + (n - 1);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
