package prefix_sum;

import java.util.Scanner;

public class static_range_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int q = sc.nextInt();

        long[] prefix = new long[n + 1];
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            int value = sc.nextInt();
            prefix[i] = prefix[i - 1] + value;
        }

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            long result = prefix[b] - prefix[a - 1];
            System.out.println(result+"");
        }
    }
}
