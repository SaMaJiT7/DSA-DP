package number_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class sherlock {
    public static final int N = (int) 1e7;
    static int prime[] = new int[N];
    static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;
        FastScanner(InputStream is) { br = new BufferedReader(new InputStreamReader(is)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
        String nextLine() throws IOException { return br.readLine(); }
    }
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();

        int max = n + 1;
        boolean[] isPrime = new boolean[max + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] color = new int[n + 1];

        int k = (n <= 2 ? 1 : 2);

        for (int i = 1; i <= n; i++) {
            int price = i + 1;            // actual price
            if (isPrime[price])
                color[i] = 1;             // prime → color 1
            else
                color[i] = 2;             // composite → 2
        }

        System.out.println(k);
        for (int i = 1; i <= n; i++)
            System.out.print(color[i] + " ");
    }

}
