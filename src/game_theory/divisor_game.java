package game_theory;

public class divisor_game {
    boolean[] dp;
    public boolean divisorGame(int n) {
        this.dp = new boolean[n+1];
        dp[1] = false;
        for(int i = 2; i <= n; i++){
            dp[i] = !dp[i-1];
        }
        return dp[n];
    }
}
