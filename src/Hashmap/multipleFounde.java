package Hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class multipleFounde{
    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;
        int num = original;
        HashSet<Integer> map = new HashSet<>();

        for(int i = 0; i < n; i++){
            map.add(nums[i]);
        }

        while(map.contains(original)){
            original = original * 2;
        }
        return original;
    }
}
