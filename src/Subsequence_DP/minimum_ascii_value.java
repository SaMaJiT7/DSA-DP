package Subsequence_DP;

public class minimum_ascii_value {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(s1.equals(s2)){
            return 0;
        }

        int[][] t = new int[n+1][m+1];

        for(int i= 1; i < n+1; i++){
            t[i][0] = t[i-1][0] + (int) s1.charAt(i-1);
        }

        for (int j = 1; j < m+1; j++) {
            t[0][j] = t[0][j-1] + (int) s2.charAt(j-1);  // Insert j chars to build word2 from empty
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = t[i-1][j-1];
                }
                else {
                    t[i][j] = Math.min(t[i-1][j] + (int) s1.charAt(i-1),t[i][j-1] + (int) s2.charAt(j-1));
                }
            }
        }
        return t[n][m];
    }
}
