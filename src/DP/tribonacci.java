package DP;

import java.util.Arrays;

public class tribonacci {
    int[] t;
    public int tribonacci(int n) {
        this.t = new int[n+1];
        Arrays.fill(t,-1);
        return solve(n);
    }
    public int solve(int i){
        if(i == 0) return 0;
        if(i == 1 || i == 2) return 1;

        if(t[i] != -1){
            return t[i];
        }

        return t[i] = solve(i-3)+solve(i-2)+solve(i-1);
    }
}
