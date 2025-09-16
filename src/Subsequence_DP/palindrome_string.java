package Subsequence_DP;

public class palindrome_string {
    public static void main(String[] args) {
        String text1 = "aebcbda";
        StringBuilder sb = new StringBuilder(text1);
        String text2 = sb.reverse().toString() ;

        int m = text1.length();
        int n = text2.length();
        int[][] t = longestCommonSubstring(text1,text2);
        System.out.println(printsubstring(t, text1, text2, m, n));
    }
    public static int[][] longestCommonSubstring(String text1, String text2) {
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

        return t;
    }
    public static String printsubstring(int[][] t, String text1, String text2, int m, int n) {
        StringBuilder s = new StringBuilder();
        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                s.append(text1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (t[i - 1][j] > t[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        s.reverse();
        return s.toString();
    }
}
