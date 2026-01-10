package number_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.StringTokenizer;

public class square_difference {
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

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            solve(sc);
        }
    }
    public static void solve(FastScanner sc) throws IOException {
        long a = sc.nextLong();
        long b = sc.nextLong();

        if (a - b != 1) {
            System.out.println("NO");
            return;
        }

        long num = a + b;
        int cnt = 0;

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                while (num % i == 0) {
                    cnt++;
                    num /= i;
                }
            }
        }
        if (num > 1) cnt++;

        System.out.println(cnt == 1 ? "YES" : "NO");
    }
}
