package Sliding_Window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class contain_duplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0; i < nums.length;i++){
            if(map.contains(nums[i])){
                return true;
            }
            else{
                map.add(nums[i]);
            }
            if(map.size() > k){
                map.remove(nums[i-k]);
            }
        }
        return false;
    }
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return true;
            }
            else{
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        return false;
    }
}
