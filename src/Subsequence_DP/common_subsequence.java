package Subsequence_DP;

import java.util.Arrays;
class common_subsequence {
//    static int[][] t = new int[1001][1001];
//    public int longestCommonSubsequence(String text1, String text2) {
//        for (int[] row : t) {
//            Arrays.fill(row, -1);
//        }
//        int m = text1.length();
//        int n = text2.length();
//        return LCS(text1,text2,m,n);
//    }
//    public static int LCS(String x , String y, int m, int n){
//        if(n == 0 || m == 0){
//            return 0;
//        }
//        if(t[m][n] != -1){
//            return t[m][n];
//        }
//
//        if(x.charAt(m-1) == y.charAt(n-1)){
//            return t[m][n] = 1 + LCS(x,y,m-1,n-1);
//        }
//        else{
//            return t[m][n] = Math.max(LCS(x,y,m-1,n),LCS(x,y,m,n-1));
//        }
//    }


public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();

    int[][] t = new int[m+1][n+1];

    for (int i = 0; i <= m ; i++){
        for(int j = 0; j <= n ; j++){
            if(i == 0 || j == 0) {
                t[i][j] = 0;
            }
        }
    }

    for (int i = 1; i < m+1 ; i++) {
        for (int j = 1; j < n+1; j++){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                t[i][j] = 1 + t[i-1][j-1];
            }
            else {
                t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
            }
        }

    }
    return t[m][n];
   }
}