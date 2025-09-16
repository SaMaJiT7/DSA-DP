package Greedy;

import java.util.Arrays;

public class Assisgn_cookies {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {3};
        System.out.println(findContentChildren(g,s));
    }
    public static int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;


        while(i < m && j < n){

            if(g[j] <= s[i]){
                j = j+1;
                i++;
            }
            else{
                i = i + 1;
            }
        }
        return j;
    }
}
