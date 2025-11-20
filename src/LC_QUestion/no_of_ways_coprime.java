package LC_QUestion;

import java.util.Arrays;

public class no_of_ways_coprime {
    static int mod = (int) (10e9 + 7);
    public int countCoprime(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] t = new int[151];
        Arrays.fill(t,0);
        t[0] = 1;
        for(int i = 0; i < n; i++){
            int[] temp = new int[151];
            Arrays.fill(temp,0);
            for(int j = 0; j < m; j++){
                for(int oldg = 0; oldg <= 150; oldg++){
                    int newg = gcd(oldg, mat[i][j]);
                    temp[newg] += t[oldg];
                    temp[newg] %= mod;
                }
            }
            t = temp;
        }
        return t[1];
    }

    public int gcd(int x , int y){
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }
}
