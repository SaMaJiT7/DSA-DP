package DP;

import java.util.Arrays;

public class count_house {
    int[] t = new int[10001];
    static int mod = (int) 1000000007;
    public int countHousePlacements(int n) {
        Arrays.fill(t,-1);
        int ways = solve(0,n);
        return (int) (((long) ways * ways) % mod);
    }
    public int solve(int i,int n){
        if(i >= n) return 1;


        if(t[i] != -1) return t[i];

        int take = solve(i+2,n);
        int skip = solve(i+1,n);

        return t[i] = ((take + skip) % mod);
    }
}
