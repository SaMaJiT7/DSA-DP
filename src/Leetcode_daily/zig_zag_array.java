package Leetcode_daily;

import java.util.Arrays;

public class zig_zag_array {
//    int l;
//    int r;
//    int k;
//    int n;
//    Integer[][][] dp;
//    int MOD = 1_000_000_007;
//    public int zigZagArrays(int n, int l, int r) {
//        this.n = n;
//        this.l = l;
//        this.r = r;
//        this.k = r - l + 1;
//        this.dp = new Integer[n+1][k+1][3];
//        return solvedp(0,k,0);
//    }
//    public int solvedp(int idx, int prev, int dir){
//        if(idx == n){
//            return 1;
//        }
//        if(dp[idx][prev][dir] != null){
//            return dp[idx][prev][dir];
//        }
//
//        long ans = 0;
//        int val = prev + l;
//
//         int smallercount = prev;
//         int biggercount = k - prev - 1;
//
//         if (prev == k) {
//             ans = (ans + solvedp(idx + 1,val,0)) % MOD;
//         }
//         else if (idx == 1) {
//                if(val != prev) {
//                    if (val > prev) {
//                        ans = (ans + solvedp(idx + 1, val, 2)) % MOD;
//                    } else {
//                        ans = (ans + solvedp(idx + 1, val, 1)) % MOD;
//                    }
//                }
//         }
//         else {
//                if(dir == 1 && val > prev){
//                    ans = (ans + solvedp(idx+1,val,2)) % MOD;
//                }
//                else if(dir == 2 && val < prev){
//                    ans = (ans + solvedp(idx+1,val,1)) % MOD;
//                }
//         }
//        return dp[idx][prev][dir] = (int) ans ;
//    }

    int MOD = 1_000_000_007;
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l  + 1;
        int[] dp = new int[m];
        Arrays.fill(dp,1);

        for(int i = 2; i <= n; i++){
            int sum = 0;
            if((i & 1) == 0){
                for(int j = 0; j < m; j++){
                    int t = dp[j];
                    dp[j] = sum;
                    sum = (sum + t) % MOD;
                }
            }
            else{
                for(int j = m-1; j >= 0; j--){
                    int t = dp[j];
                    dp[j] = sum;
                    sum = (sum + t) % MOD;
                }
            }
        }
        int res = 0;
        for(int j = 0; j < m; j++){
            res = (res + dp[j]) % MOD;
        }

        return (res << 1) % MOD;
    }
}
