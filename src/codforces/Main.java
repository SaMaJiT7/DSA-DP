package codforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        long n = fs.nextLong();
        long k = fs.nextLong();
        int q = fs.nextInt();
        long[] range = new long[200001];
        Arrays.fill(range,0);
        for(int i = 0; i < n; i++){
            int l = fs.nextInt();
            int r = fs.nextInt();
            range[l]++;
            if(r+1 < 200001) range[r+1]--;
        }
        for(int i = 1; i < 200001; i++) range[i] += range[i-1];

        for(int i = 1; i < 200001; i++){
            if(range[i] >= k) range[i] = 1;
            else range[i] = 0;
        }
        for(int i = 1; i < 200001; i++){
            range[i] += range[i-1];
        }
        for(int i = 0; i < q; i++){
            int a = fs.nextInt();
            int b = fs.nextInt();
            System.out.println(range[b] - range[a-1]);
        }
    }
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
}
