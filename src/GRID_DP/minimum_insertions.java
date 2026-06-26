package GRID_DP;

public class minimum_insertions {
    public int minInsertions(String s) {
        int n = s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        int m = s2.length();
        int lps = lps(s,s2);

        return n - lps;
    }
    public int lps(String x, String y){
        int n = x.length();
        int m = y.length();
        int[][] dp = new int[n+1][m+1];
        for(int j = 0; j < m; j++){
            dp[0][j] = 0;
        }
        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }
        int lcs = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp[n][m];
    }
}
