package DP;

import java.util.Arrays;

public class Decode_strings {
    int[] t ;
    public int numDecodings(String s) {
        int n = s.length();
        this.t = new int[n];
        Arrays.fill(t,-1);
        return solve(s,0,n);
    }
    public int solve(String s,int i,int n) {
        if (i == n) return 1;
        if (s.charAt(i) == '0') return 0;

        if(t[i] != -1){
            return t[i];
        }
        int ways = solve(s,i+1,n);
        int ways2 = 0;
        if(i+1 < n) {
            char ch = s.charAt(i);
            char ch2 = s.charAt(i + 1);
            int n1 = ch - '0';
            int n2 = ch2 - '0';
            int num = n1 * 10 + n2;
            if (num >= 10 && num <= 26) {
                ways2 = solve(s,i+2,n);
            }
        }

        return t[i] = ways + ways2;
    }
}
