package Subsequence_DP;

public class longest_palindromic_seq {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("aabb"));
    }
    public static int longestPalindromeSubseq(String s) {
        int m = s.length();
        StringBuilder sb = new StringBuilder(s);
        String text1 = s;
        String text2 = sb.reverse().toString();
        return (m - longestCommonSubsequence(text1,text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
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
