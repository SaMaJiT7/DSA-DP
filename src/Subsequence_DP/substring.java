package Subsequence_DP;

public class substring {
    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("abcde","abfce"));
    }
    public static int longestCommonSubstring(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] t = new int[m+1][n+1];
        int maxLength = 0;



        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                    maxLength = Math.max(maxLength, t[i][j]);
                } else {
                    t[i][j] = 0;
                }
            }
        }

        return maxLength;
    }

}
