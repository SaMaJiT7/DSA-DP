package knapsack;

import java.util.Arrays;

public class dice_combinations {
    static long[] dp;
    static long mod = 1000000007; // Correct modulo

    public static long dice_combo(int n) {
        dp = new long[n + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int x = 1; x <= 6; x++) {
                if (x > i) break;
                dp[i] = (dp[i] + dp[i - x]) % mod;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(dice_combo(n)); // Expected output: 4
    }
}

