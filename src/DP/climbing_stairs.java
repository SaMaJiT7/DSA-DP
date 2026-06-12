package DP;

import java.util.Arrays;

public class climbing_stairs {
    int[] t;
    public int climbStairs(int n) {
        this.t = new int[n];
        Arrays.fill(t,-1);
        return solve(0,n);
    }
    public int solve(int i, int n){
        if(i == n){
            return 1;
        }
        if (t[i] != -1){
            return t[i];
        }
        int oneway = solve(i+1,n);
        int twoway = 0;
        if(i+2 <= n){
            twoway = solve(i+2,n);
        }
        return t[i] = oneway + twoway;
    }
}
