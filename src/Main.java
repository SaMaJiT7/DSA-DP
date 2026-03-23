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


//    public static void main(String[] args) throws IOException {
//        FastScanner Sc = new FastScanner(System.in);
//
////        int n = Sc.nextInt();
////        int ans = 0;
////        for(int i = 2; i <= n; i++){
////            int cnt = 0;
////            int num = i;
////            for(int j = 2; j*j <= num; j++){
////                if(num % j == 0){
////                    cnt++;
////                    while(num % j == 0){
////                        num /= j;
////                    }
////                }
////            }
////            if(num > 1){
////                cnt++;
////            }
////            if(cnt == 2){
////                ans++;
////            }
////        }
////        System.out.println(ans);
//        int t = Sc.nextInt();
//
//        while(t-- > 0){
//            int n = Sc.nextInt();
//            int m = Sc.nextInt();
//
//            char[][] grid = new char[n][m];
//            for(int i = 0; i < n; i++){
//                String s = Sc.nextLine();
//                for(int j = 0; j < m; j++){
//                    grid[i][j] = s.charAt(j);
//                }
//            }
//
//            if(grid[0][0] == grid[n-1][m-1] || grid[n-1][0] == grid[0][m-1]){
//                System.out.println("YES");
//            }
//            else{
//                String ans = "YES";
//                boolean impossible = true;
//
//                for(int j = 0; j < m-1; j++){
//                    if(grid[0][j] != grid[0][j+1] || grid[n-1][j] != grid[n-1][j+1]){
//                        impossible = false;
//                    }
//                }
//
//                if(impossible){
//                    ans = "NO";
//                }
//
//                impossible = true;
//                for(int i = 0; i < n-1; i++){
//                    if(grid[i][0] != grid[i+1][0] || grid[i][m-1] != grid[i+1][m-1]){
//                        impossible = false;
//                    }
//                }
//                if(impossible){
//                    ans = "NO";
//                }
//                System.out.println(ans);
//            }
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        FastScanner sc = new FastScanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++){
//            arr[i] = sc.nextInt();
//        }
//        Arrays.sort(arr);
//
//        if(arr[0] != 1){
//            System.out.println(1);
//        }
//        else{
//            long minsum = 0;
//            long maxsum = 1;
//
//            for(int i = 1; i < n; i++){
//               long newminsum = arr[i] + minsum;
//               long newmaxsum = arr[i] + maxsum;
//
//               if(newminsum - maxsum > 1){
//                   break;
//               }
//               maxsum = Math.max(maxsum,newmaxsum);
//            }
//            System.out.println(maxsum+1);
//        }
//    }

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
}
