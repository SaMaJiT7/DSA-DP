import java.io.*;
import java.util.*;

public class Main {
//    public static void main(String[] args) throws Exception {
//        FastScanner fs = new FastScanner(System.in);
//
//        int t = fs.nextInt();
//        while (t-- > 0) {
//            long X0 = fs.nextLong();
//            long n = fs.nextLong();
//
//            long ans = 0;
//            if (n % 4 == 1) ans = -n;
//            else if (n % 4 == 2) ans = 1;
//            else if (n % 4 == 3) ans = n + 1;
//            else ans = 0;
//
//            if (X0 % 2 == 0) ans = X0 + ans;
//            else ans = X0 - ans;
//
//            System.out.println(ans);
//        }
//    }

//        int n = fs.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) a[i] = fs.nextInt();
//
//        Arrays.sort(a);
//        int median = a[n / 2];
//
//        long ans = 0;
//        for (int i = 0; i < n; i++) ans += Math.abs((long)a[i] - median);
//
//        // Use PrintWriter for fast output (optional for single number)
//        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//        out.println(ans);
//        out.flush();

//    public static void main(String[] args) throws IOException {
//        FastScanner fs = new FastScanner(System.in);
//        int n = fs.nextInt() , k = fs.nextInt();
//        long[] arr = new long[n];
//        int x = fs.nextInt() , a = fs.nextInt() , b = fs.nextInt() , c = fs.nextInt();
//        arr[0] = x;
//        for(int i = 1; i < n; i++){
//            arr[i] = (arr[i-1] * a + b) % c;
//        }
//        long ans = helper(arr,k);
//        System.out.println(ans);
//    }
//
//    public static long helper(long[] nums, int k){
//        long n = nums.length;
//        int i = 0;
//        int j = 0;
//        long xor = 0;
//        long sum = 0;
//
//        while(j < n){
//            xor ^= nums[j] ;
//
//            if(j-i+1 < k){
//                j++;
//            }
//            else if (j-i+1 == k){
//                sum = (sum ^ xor)  ;
//                xor ^= nums[i];
//                j++;
//                i++;
//            }
//
//        }
//        return sum;
//    }


    // Fast scanner using BufferedReader + StringTokenizer
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

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int[][] grid = new int[N][M];
//
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                grid[i][j] = sc.nextInt();
//            }
//        }
//        int ans = solve(grid,0,0,N,M);
//        System.out.println(ans);
//    }
//    public static int solve(int[][] grid, int i, int j,int n, int m){
//        if(i == n-1 && j == m-1){
//            return grid[i][j];
//        }
//        if(i < n-1){
//            if(j < m-1){
//                return Math.max(solve(grid,i+1,j,n,m)+grid[i][j],solve(grid,i,j+1,n,m)+grid[i][j]);
//            }
//            else{
//                return solve(grid,i+1,j,n,m)+grid[i][j];
//            }
//        }
//        else{
//            return solve(grid,i,j+1,n,m)+grid[i][j];
//        }
//    }


    public static void main(String[] args) throws IOException {
        FastScanner Sc = new FastScanner(System.in);

        int n = Sc.nextInt();
        int ans = 0;
        for(int i = 2; i <= n; i++){
            int cnt = 0;
            int num = i;
            for(int j = 2; j*j <= num; j++){
                if(num % j == 0){
                    cnt++;
                    while(num % j == 0){
                        num /= j;
                    }
                }
            }
            if(num > 1){
                cnt++;
            }
            if(cnt == 2){
                ans++;
            }
        }
        System.out.println(ans);
    }

}
