package Leetcode_daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class maximum_no_elemen_subset {
    public int maximumLength(int[] nums) {
//        TreeMap<Integer,Integer> map = new TreeMap<>();
//        for(int i = 0; i < nums.length; i++){
//            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//        }
//        int Maxlen = 0;
//        if(map.containsKey(1)){
//            int c = map.get(1);
//            if(c % 2 == 0){
//                Maxlen = c-1;
//            }
//            else{
//                Maxlen = c;
//            }
//        }
//        for(int x : map.keySet()) {
//            if(x == 1) continue;
//            long currX = (long) x;
//            int currlen = 0;
//
//            while (map.containsKey((int) currX) && map.get((int) currX) >= 2) {
//                currlen += 2;
//                currX = currX * currX;
//
//                if (currX > 1000000000) break;
//            }
//
//            Maxlen = Math.max(Maxlen,currlen + ((map.containsKey((int) currX)) ? 1 : -1));
//        }
//        return Maxlen;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int MaxLen = 0;
        if(map.containsKey(1)){
            int c = map.get(1);
            MaxLen = ((c & 1) != 0 ? c : c-1);
        }
        for(int x : map.keySet()){
            if(x == 1) continue;

            long current = x;
            int currLength = 0;

            while(map.containsKey((int)current) && map.get((int) current) >= 2){
                currLength += 2;
                current = current * current;
            }

            currLength = currLength + (map.containsKey((int)current) ? 1 : -1);
            MaxLen = Math.max(MaxLen,currLength);
        }
        return MaxLen;
    }
}
