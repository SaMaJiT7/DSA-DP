package Subsequence_DP;

public class edit_distance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if(word1.equals(word2)){
            return 0;
        }

        int[][] t = new int[m+1][n+1];

        // Initialize boundaries
        for (int i = 0; i <= m; i++) {
            t[i][0] = i;  // Delete i chars to make word1 empty
        }
        for (int j = 0; j <= n; j++) {
            t[0][j] = j;  // Insert j chars to build word2 from empty
        }


        for (int i = 1; i < m+1 ; i++) {
            for (int j = 1; j < n+1; j++){

                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    t[i][j] = t[i-1][j-1];
                }
                else {
                    t[i][j] = 1 + Math.max(Math.min(t[i-1][j],t[i][j-1]),t[i-1][j-1]);
                }
            }
        }
        return t[m][n];
    }
}
