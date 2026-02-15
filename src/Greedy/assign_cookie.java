package Greedy;

import java.util.Arrays;

public class assign_cookie {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while(i < m && j < n){
            if(g[j] <= s[i]){
                j = j + 1;
                i++;
            }
            else{
                i = i + 1;
            }
        }
        return j;
    }
}
