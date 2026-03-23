package Leetcode_daily;

public class STABLE_BINARY_ii {
    static int MOD = (int) (1e9 + 7);
    int[][][] dp;
    public int numberOfStableArrays(int zero, int one, int limit) {
        this.dp = new int[zero+1][one+1][2];
        for(int i = 0; i <= Math.min(zero,limit); i++){
            dp[i][0][0] = 1;
        }
        for(int j = 0; j <= Math.min(one,limit); j++){
            dp[0][j][1] = 1;
        }

        for (int i = 0; i <= zero; i++) { //i = no of zeroes
            for (int j = 0; j <= one; j++) { //j = no of ones
                if(i == 0 || j == 0){
                    continue;
                }

                dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % MOD;
                if(i-1 >= limit){
                    dp[i][j][0] = (dp[i][j][0] - dp[i-1-limit][j][1] + MOD) % MOD;
                }
                dp[i][j][1] = (dp[i][j-1][0] + dp[i][j-1][1]) % MOD;
                if(j-1 >= limit){
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j-1-limit][0] + MOD) % MOD;
                }
            }
        }
        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
    }
}
