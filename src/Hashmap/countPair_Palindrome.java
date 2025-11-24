package Hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class countPair_Palindrome {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        if(n < 3){
            return 0;
        }
        if(n == 3){
            if(s.charAt(0) != s.charAt(2)){
                return 0;
            }
            else{
                return 1;
            }
        }

        for(int i = 0; i < n; i++){
            int idx = s.charAt(i) - 'a';
            if(first[idx] == -1) first[idx] = i;
            last[idx] = i;
        }

        int count = 0;

        for(int c = 0; c < 26; c++){
            if(first[c] != -1 && last[c] - first[c] >= 2){

                boolean[] seen = new boolean[26];

                for(int mid = first[c]+1; mid < last[c]; mid++){
                    int num = s.charAt(mid) - 'a';
                    seen[num] = true;
                }

                for(boolean b : seen){
                    if(b) count++;
                }
            }
        }
        return count;
    }
}
