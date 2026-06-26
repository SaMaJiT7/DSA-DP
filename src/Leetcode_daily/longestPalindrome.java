package Leetcode_daily;

import java.util.Arrays;

public class longestPalindrome {
    public String longestPalindrome(String s) {
        StringBuilder t = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            t.append('#');
            t.append(s.charAt(i));
        }
        t.append('#');
        String s1 = t.toString();
        int n = s1.length();
        int[] p = new int[n];
        Arrays.fill(p,1);
        int c = 1;
        int r = 1;
        for(int i = 1; i < n; i++){
            if(i < r) {
                p[i] = Math.min(r - i, p[2 * c - i]);
            }
            while(i+p[i] < n && i -p[i] >=0 && s1.charAt(i+p[i]) == s1.charAt(i-p[i])){
                p[i]++;
            }
            if(i+p[i] > r){
                c = i;
                r = i+p[i];
            }
        }

        int maxlen = 0;
        int center = 0;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(p[i] > maxlen){
                maxlen = p[i]-1;
                center = i;
            }
        }
        int start = (center - maxlen) / 2;

        return s.substring(start,start + maxlen);
    }
}
