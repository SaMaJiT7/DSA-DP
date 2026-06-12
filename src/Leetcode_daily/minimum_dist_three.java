package Leetcode_daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class minimum_dist_three {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
            if(map.containsKey(nums[i]) && map.get(nums[i]).size() >= 3){
                List<Integer> vec = map.get(nums[i]);
                int k = vec.get(vec.size()-3);
                ans = Math.min(ans,(i - k));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : 2*ans;
    }
}
