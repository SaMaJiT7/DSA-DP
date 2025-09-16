package prefix_sum;

import java.util.HashMap;

public class count_nice_subarray {


    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }
        map.put(0,1);
        for(int i = 0; i < n; i++){
            sum += nums[i];
            ans += map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}