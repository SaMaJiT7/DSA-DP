package Leetcode_daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class minimum_mirror_dist {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                int dist = Math.abs(i - map.get(nums[i]));
                ans = Math.min(ans, dist);
            }
            map.put(reverse(nums[i]), i);
        }
    return (ans == Integer.MAX_VALUE ? -1 : ans);
}
    public int reverse(int n){
        int rev = 0;
        while(n > 0){
            rev = (rev * 10) + (n % 10);
            n = n / 10;
        }

        return rev;
    }
}
