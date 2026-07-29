package Leetcode_daily;

import java.util.HashSet;

public class triplets_II {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i = 0; i < n; i++) max = Math.max(max,nums[i]);
        int size = 1;
        while (size <= max) {
            size = size * 2;
        }
        boolean[] pairXor = new boolean[size];
        boolean[] tripletXor = new boolean[size];

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }

        for(int i = 0; i < size; i++){
            if(!pairXor[i]) continue;
            for(int num : nums){
                tripletXor[num ^ i] = true;
            }
        }
        int count = 0;
        for(boolean g : tripletXor){
            if(g) count++;
        }

        return count;
    }
}
