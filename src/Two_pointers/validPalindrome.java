package Two_pointers;

import java.util.HashMap;

public class validPalindrome {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int del = 1;
        int[] charFreq = new int[26];
        for(char ch : s.toCharArray()){
            charFreq[ch-'a']++;
        }
        int i = 0;
        int j = n-1;
        while(i <= j){
            char f = s.charAt(i);
            char b = s.charAt(j);
            if(f == b){
                i++;
                j--;
            }
            else{
                boolean right = checkPalindrome(i+1,j,s);
                boolean left = checkPalindrome(i,j-1,s);
                return left || right;
            }
        }
        return true;
    }
    public boolean checkPalindrome(int i , int j,String s){
        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}
