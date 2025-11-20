package Hashmap;

import java.util.HashMap;

public class smallest_missing {
    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer,Integer> count = new HashMap<>();
        for(int num : nums){
            int rem = (num % value + value) % value;
            count.put(rem,count.getOrDefault(rem,0)+1);
        }

        int MEX = 0;
        while(true){
            int rem = MEX % value;
            int freq = count.getOrDefault(rem,0);
            if(freq == 0){
                return MEX;
            }
            count.put(rem,freq-1);
            MEX++;
        }
    }
}
