package Leetcode_daily;

public class zigzagArrays {
        static private int MOD = 1_000_000_007;
        public int zigZagArrays(int n, int l, int r) {
            int M = r - l + 1;
            if (n == 1)
                return M;

            int size = 2 * M;
            int[] state = new int[2 * M];
            for (int i = 0; i < 2 * M; i++)
                state[i] = 1;

            int[][] T = new int[size][size];

            for (int v = 0; v < M; v++) {
                for (int u = 0; u < v; u++) {
                    T[M + v][u] = 1;
                }
            }
            for (int v = 0; v < M; v++) {
                for (int u = v + 1; u < M; u++) {
                    T[v][M + u] = 1;
                }
            }

            int[] state_n = multiply(matrixExp(T, n - 1), state);

            long ans = 0;
            for (int x : state_n) {
                ans = (ans + x) % MOD; // Safe modulo addition inside the loop
            }

            return (int) ans;
        }
        public int[][] matrixExp(int[][] base, int Exponent){
            if(Exponent == 0){
                int n = base.length;
                int[][] I = new int[n][n];
                for(int i = 0; i < n; i++)
                    I[i][i] = 1;
                return I;
            }
            int[][] half = matrixExp(base,Exponent/2);
            int[][] result = matrixMult(half,half);
            if(Exponent % 2 == 1){
                result = matrixMult(result,base);
            }

            return result;
        }

        public int[] multiply(int[][] T, int[] state){
            int n = T.length;
            int[] res = new int[n];

            for(int i = 0; i < n; i++){
                long sum = 0;

                for (int j = 0; j < n; j++) {

                    sum = (sum + (long) T[i][j] * state[j]) % MOD;
                }
                res[i] = (int) sum;
            }

            return res;
        }
        public int[][] matrixMult(int[][] A, int[][] B){
            // A = X * Y | B = Y * Z ---> C = X * Z;
            int n = A.length; int m = B[0].length;
            int[][] C = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    long sum = 0;
                    for (int k = 0; k < B.length; k++) {

                        sum = (sum + (long) A[i][k] * B[k][j]) % MOD;
                    }
                    C[i][j] = (int) sum;
                }
            }
            return C;
        }
}
