package Sliding_Window;

import java.util.HashMap;

public class char_replacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int[] freq = new int[26];
        int maxfreq = 0;
        int maxlen = 0;

        while(j < n){
            int ch = s.charAt(j) - 'A';
            freq[ch]++;
            maxfreq = Math.max(maxfreq,freq[ch]);


            if(j-i+1 - maxfreq <= k){
                maxlen = Math.max(maxlen,j-i+1);
            }

            while(j-i+1 - maxfreq > k){
                freq[s.charAt(i)-'A']--;
                i++;
            }
            maxlen = Math.max(maxlen,j-i+1);
            j++;
        }
        return maxlen;
    }
}
