package Hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class longest_sequence {
    public int longestConsecutive(int[] nums) {
        int Maxcount = 0;
        HashSet<Integer> map = new HashSet<>();
        for(int x : nums){
            map.add(x);
        }

        for(int num : map){
            if(map.contains(num-1)){
                continue;
            }
            else{
                int count = 1;
                int x = num;
                while(map.contains(x+1)){
                    x = x + 1;
                    count++;
                }
                Maxcount = Math.max(Maxcount,count);
            }
        }
        return Maxcount;
    }
}
