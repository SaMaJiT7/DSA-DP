package Greedy;

import java.util.HashMap;

public class palindrome {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> freqMap = new HashMap<>();
        int n = words.length;
        boolean hasCenter = false;
        for(int i = 0; i < n; i++){
            freqMap.put(words[i], freqMap.getOrDefault(words[i],0)+1);
        }
        int maxlength = 0;
        for(int i = 0; i < n; i++){
            String s = words[i];
            String res = "" + s.charAt(1) + s.charAt(0);
            if(!s.equals(res)) {
                if (freqMap.containsKey(s) && freqMap.containsKey(res) && freqMap.get(s) > 0 && freqMap.get(res) > 0) {
                    freqMap.put(s, freqMap.get(s) - 1);
                    freqMap.put(res, freqMap.get(res) - 1);
                    if (freqMap.get(s) == 0) freqMap.remove(s);
                    if (freqMap.get(res) == 0) freqMap.remove(res);
                    maxlength += 4;
                }
            }
            else{
                if(freqMap.containsKey(res) && freqMap.get(res) >= 2){
                    int pairs = freqMap.get(res) / 2;
                    maxlength += pairs*4;
                    freqMap.put(res,freqMap.get(res)-2*pairs);
                }
                if(freqMap.get(res) > 0){
                    hasCenter = true;
                }
            }
        }
        if(hasCenter) maxlength +=2;
        return maxlength;
    }
}
