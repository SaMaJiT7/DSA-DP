package Leetcode_daily;

public class product_matrix {
    static int MOD = 12345;
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[][] suffix = new long[n][m];
        long prod = 1;
        for(int i = n-1; i >= 0 ; i--){
            for(int j = m-1; j >= 0; j--){
                suffix[i][j] = prod;
                prod = (prod * grid[i][j]) % MOD;
            }
        }
        prod = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = (int) ((suffix[i][j] * prod) % MOD);
                prod = (prod * grid[i][j]) % MOD;
            }
        }
        return grid;
    }
}
