package Leetcode_daily;

import charcount.Entry;

import java.util.*;

public class minDeletions {
    public int minDeletion(String s, int k) {
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int d = map.size() - k;
        if(d <= 0){
            return 0;
        }
        List<Integer> nums = new ArrayList<>(map.values());
        Collections.sort(nums);
        for(int i = 0; i < d; i++){
            ans = ans + nums.get(i);
        }
        return ans;
    }
}
