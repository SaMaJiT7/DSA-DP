package LC_QUestion;

import java.util.Arrays;

public class matrix {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n+1];

        for(int[] q : queries){
            int row1 = q[0];
            int row2 = q[2];
            int col1 = q[1];
            int col2 = q[3];

            for(int i = row1; i <= row2; i++){
                mat[i][col1] += 1;
                mat[i][col2+1] -= 1;
            }
        }

        int[][] result = new int[n][n];

        for(int i = 0; i < n; i++){
            int running = 0;
            for(int j = 0; j < n; j++){
                running += mat[i][j];
                result[i][j] = running;
            }
        }
        return result;
    }
}
