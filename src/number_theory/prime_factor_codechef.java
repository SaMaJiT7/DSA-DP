package number_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class prime_factor_codechef {
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
    static int N = (int) 1e7;
    static int spf[] = new int[N];
    public static void main(String[] args) throws IOException {

        for(int i = 1; i < N; i++){
            spf[i] = i;
        }
        for(int i = 2; i * i < N ; i++){
            if(spf[i] == i){
                for(int j = i * i; j < N; j += i){
                    if(spf[j] == j){
                        spf[j] = i;
                    }
                }
            }
        }
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            solve(sc);
        }
    }


    public static void solve(FastScanner sc) throws IOException{
        int x = sc.nextInt();
        int y = sc.nextInt();
        String s1 = Integer.toString(x);
        String s2 = Integer.toString(y);
        char[] arr = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(arr2);

        Set<Integer> dx = new HashSet<>();
        Set<Integer> dy = new HashSet<>();


        do{
            String sorted = new String(arr);

            if(sorted.charAt(0) == '0') continue;

            int num = Integer.parseInt(sorted);

            while(num > 1){
                dx.add(spf[num]);
                num /= spf[num];
            }

        } while(nextPermutation(arr));

        do{
            String sorted = new String(arr2);

            if(sorted.charAt(0) == '0') continue;

            int num = Integer.parseInt(sorted);

            while(num > 1){
                dy.add(spf[num]);
                num /= spf[num];
            }

        } while(nextPermutation(arr2));
        int ans = 1;
        for(int val : dx){
            if(!dy.contains(val)){
                ans = val;
            }
        }
        System.out.println(ans);
    }
    static boolean nextPermutation(char[] arr) {
        int n = arr.length;
        int i = n - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) i--;

        if (i < 0) return false;

        int j = n - 1;
        while (arr[j] <= arr[i]) j--;

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        int l = i + 1, r = n - 1;
        while (l < r) {
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

        return true;
    }


}
