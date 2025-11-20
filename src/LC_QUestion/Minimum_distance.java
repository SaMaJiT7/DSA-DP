package LC_QUestion;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
public class Minimum_distance {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    if(nums[i] == nums[j] && nums[j] == nums[k]){
                        ans = Math.min(ans,2*(k-i));
                    }
                }
            }
        }
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
    public int minimumDistance2(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;

        HashMap<Integer,Queue<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.putIfAbsent(nums[i], new LinkedList<>());

            if(map.containsKey(nums[i]) && map.get(nums[i]).size() > 1){
                ans = Math.min(ans, 2*(i - map.get(nums[i]).peek()));
            }
            map.get(nums[i]).add(i);
            if(map.get(nums[i]).size() > 2) map.get(nums[i]).poll();
        }
       return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
