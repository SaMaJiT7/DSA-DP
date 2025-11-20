package Greedy;

import java.util.HashMap;

public class longest_palindrome {
    public int longestPalindrome(String s) {
        int[] map = new int[126];
        boolean hasodd = false;
        int oddcharactercount = 0;

        for(char ch : s.toCharArray()) {
            map[ch]++;
        }

        for(int freq : map){
            oddcharactercount += (freq/2)*2;
            if(freq % 2 == 1){
                hasodd = true;
            }
        }

        if(hasodd) oddcharactercount++;
        return oddcharactercount;
    }
}
