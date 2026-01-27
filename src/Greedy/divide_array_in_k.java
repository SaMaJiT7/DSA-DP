package Greedy;

import java.util.Arrays;
import java.util.HashMap;

public class divide_array_in_k {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        if(n % k != 0){
            return false;
        }
        HashMap<Integer,Integer> Map = new HashMap<>();
        for(int num : nums){
            Map.put(num,Map.getOrDefault(num,0)+1);
        }
        int count = 0;

        for(int i = 0; i < n; i++){
            int val = nums[i];
            if(Map.get(val) == 0){
                continue;
            }
            for(int j = 0; j < k; j++){
                int target = val + j;
                if(Map.getOrDefault(target,0) > 0){
                    Map.put(target,Map.get(target)-1);
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
