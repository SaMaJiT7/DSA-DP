package Hashmap;

import java.util.HashMap;

public class majority_element {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }


        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        return -1;
        }
}
