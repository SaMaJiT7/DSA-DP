package Subsequence_DP;

public class mini_no_del_add {
    public static void main(String[] args) {
        String text1 = "heap";
        String text2 = "pea";

        int m = text1.length();
        int n = text2.length();

        minimum_no(text1, text2);
        int[][] t = longestCommonSubsequence1(text1, text2);
        System.out.println(printsubsequence(t, text1, text2, m, n));
    }



    public static int[][] longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] t = new int[m + 1][n + 1];


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        return t;
    }

    public static String printsubsequence(int[][] t, String text1, String text2, int m, int n) {
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


    public static int minimum_no(String text1, String text2) {
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
        return m - t[m][n] + n - t[m][n];
    }
}
