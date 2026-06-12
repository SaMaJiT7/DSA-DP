package DP;

import java.util.Arrays;

public class MinimumDistance {
//    int[][][] t;
//    int n;
//    public int minimumDistance(String word) {
//        this.n = word.length();
//        this.t = new int[n][27][27];
//        for(int[][] row : t){
//            for(int[] col : row){
//                Arrays.fill(col,-1);
//            }
//        }
//        int ans = solve(0,26,26,word);
//        return ans;
//    }
//    public int dist(int a, int b){
//        if(a == 26 || b == 26){
//            return 0;
//        }
//        int r1 = a / 6;
//        int c1 = a % 6;
//        int r2 = b / 6;
//        int c2 = b % 6;
//
//        return (Math.abs(r2-r1) + Math.abs(c2-c1));
//    }
//
//    public int solve(int i, int l, int r,String word){
//        if(i == n) return 0;
//        int curr = word.charAt(i) - 'A';
//        if(t[i][l][r] != -1){
//            return t[i][l][r];
//        }
//        //move leftHand
//        int moveleft = dist(l,curr) + solve(i+1,curr,r,word);
//
//        //move rightHand
//        int moveright = dist(r,curr) + solve(i+1,l,curr,word);
//
//        return t[i][l][r] = Math.min(moveleft,moveright);
//    }

    int[][][] dp;
    int n;
    public int minimumDistance(String word) {
        this.n = word.length();
        this.dp = new int[n+1][27][27];
        for(int l = 0; l < 27; l++){
            for(int r = 0; r < 27; r++){
                dp[n][l][r] = 0;
            }
        }
        for(int i = n-1; i >= 0; i--){
            for(int l = 0; l < 27; l++){
                for(int r = 0; r < 27; r++){
                    int curr = word.charAt(i) - 'A';

                    dp[i][l][r] = Math.min(dist(l,curr) + dp[i+1][curr][r] , dist(r,curr) + dp[i+1][l][curr]);
                }
            }
        }
        return dp[0][26][26];
    }

    public int dist(int a, int b){
        if(a == 26 || b == 26){
            return 0;
        }
        int r1 = a / 6;
        int c1 = a % 6;
        int r2 = b / 6;
        int c2 = b % 6;

        return (Math.abs(r2-r1) + Math.abs(c2-c1));
    }
}
