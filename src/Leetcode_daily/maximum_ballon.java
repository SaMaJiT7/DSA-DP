package Leetcode_daily;

import java.util.HashMap;

public class maximum_ballon {
//    public int maxNumberOfBalloons(String text) {
//        HashMap<Character,Integer> freq = new HashMap<>();
//        for(char ch : text.toCharArray()){
//            freq.put(ch,freq.getOrDefault(ch,0)+1);
//        }
//        int ans = Integer.MAX_VALUE;
//        for(char ch : "balloon".toCharArray()){
//            if(freq.get(ch) == null) return 0;
//
//            if(ch == 'o' || ch == 'l'){
//                ans = Math.min(ans,freq.get(ch)/2);
//            }
//            else{
//                ans = Math.min(ans,freq.get(ch));
//            }
//        }
//        return ans;
//    }
public int maxNumberOfBalloons(String text) {
    int ans = 0;
    int[] freq = new int[26];
    for(char ch : text.toCharArray()){
        freq[ch-'a']++;
    }
    int count = Integer.MAX_VALUE;
    for(char ch : "balloon".toCharArray()){
        if(freq[ch-'a'] == 0) return 0;
        if(ch == 'l' || ch == 'o'){
            count = Math.min(count,freq[ch-'a']/2);
        }
        count = Math.min(count,freq[ch-'a']);
    }
    return count;
}
}
