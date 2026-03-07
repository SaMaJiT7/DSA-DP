import java.util.Scanner;

public class minimum_subset_diff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int range = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        for (int i = 0; i < n; i++) {
            range = range + arr[i];
        }

        boolean[][] dp = new boolean[n + 1][range + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= range; j++) {
                if (arr[i - 1] < j) {
                    if (arr[i - 1] <= j) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int j = range / 2; j >= 0; j--) {
            if (dp[n][j]) {
                minDiff = range - 2 * j;
                break;
            }
        }
        System.out.println(minDiff);
    }
}
