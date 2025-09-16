public class k_factor_balance {
    public int[] minDifference(int n, int k) {
        if (n < k) return null;
        int maxGCD = 1;
        for (int d = 1; d * d <= n; d++) {
            if (n % d == 0 && n % (n-d) == 0) {
                if (d >= k) maxGCD = Math.min(maxGCD, n-d);
                int complement = n / d;
                if (complement >= k) maxGCD = Math.min(maxGCD , n- complement);
            }
        }
        return new int[]{n - maxGCD};
    }
}
