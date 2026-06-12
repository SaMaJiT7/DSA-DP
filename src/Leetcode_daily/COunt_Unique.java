package Leetcode_daily;

import java.util.Arrays;

public class COunt_Unique {
    public int numberOfSpecialChars1(String word) {
        boolean[] upper = new boolean[26];
        boolean[] lower = new boolean[26];
        for(char c : word.toCharArray()){
            if(Character.isLowerCase(c)){
                lower[c-'a'] = true;
            }
            else{
                upper[c-'A'] = true;
            }
        }
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(lower[i] && upper[i]){
                count = count + 1;
            }
        }
        return count;
    }
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] firstpos = new int[26];
        int[] lastpos = new int[26];
        Arrays.fill(firstpos,-1);
        Arrays.fill(lastpos,-1);
        for(int i = 0; i < n; i++){
            char c = word.charAt(i);
            if(Character.isLowerCase(c)){
                lastpos[c-'a'] = i;
            }
            else{
                firstpos[c-'A'] = i;
            }
        }
        int unique = 0;
        for(int i = 0; i < 26; i++){
            if(firstpos[i] != -1 && lastpos[i] != -1 && lastpos[i] < firstpos[i]){
                unique += 1;
            }
        }
        return unique;
    }
}
