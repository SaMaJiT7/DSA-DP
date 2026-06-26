package Leetcode_daily;

import java.util.HashMap;

public class count_majority_element {
//    public int countMajoritySubarrays(int[] nums, int target) {
//        int n = nums.length;
//        int count = 0;
//        for(int i = 0; i < n; i++){
//            HashMap<Integer,Integer> map = new HashMap<>();
//            for(int j = i; j < n; j++){
//                map.put(nums[j],map.getOrDefault(nums[j],0) + 1);
//
//                if(!map.containsKey(target)) continue;
//
//                if(map.get(target) > (j-i+1) / 2){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
public int countMajoritySubarrays(int[] nums, int target) {
    int n = nums.length;
    int count = 0;
    int cum = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0,1);
    int valid_left = 0;
    for(int i = 0; i < n; i++){
        int currsum = cum;
        if(nums[i] == target) {
            valid_left += map.get(currsum);
            cum += 1;
        }
        else{
            cum -= 1;
            valid_left -= map.getOrDefault(cum,0);
        }

        count += valid_left;
        map.put(cum,map.getOrDefault(cum,0)+1);
    }
    return count;
}
}
