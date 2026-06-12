package Leetcode_daily;

import java.util.Arrays;

public class jump_gameV {
    int[] dp;
    int n;

    public int maxJumps(int[] arr, int d) {
       this.n = arr.length;
       this.dp = new int[n];
        Arrays.fill(dp,-1);
       int max = 0;
       for(int i = 0; i < n; i++){
             max = Math.max(max,dfs(arr,i,d));
       }
        return max;
    }
    public int dfs(int[] arr, int i, int d){
        if(dp[i] != -1){
            return dp[i];
        }
        int best = 1;
        for(int x = 1; x <= d; x++) {
            if (i - x >= 0) {
                int next = i - x;
                if (arr[i] <= arr[next]) {
                    break;
                }
                best = Math.max(best, 1 + dfs(arr, next, d));
            }
        }

        for(int x = 1; x <= d; x++) {
            if (i + x < n) {
                int next = i + x;
                if (arr[i] <= arr[next]) {
                    break;
                }
                best = Math.max(best, 1 + dfs(arr, next, d));
            }
        }

        return dp[i] = best;
    }
}
