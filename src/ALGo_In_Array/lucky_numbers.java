package ALGo_In_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lucky_numbers {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] minCol = new int[m];
        Arrays.fill(row, Integer.MAX_VALUE);
        int[] col = new int[n];
        List<Integer> ans = new ArrayList<>();

        //Min element in row i
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               if(matrix[i][j] < row[i]){
                   row[i] = matrix[i][j];
                   minCol[i] = j;
               }
            }
        }


        //Max element in col i
        for(int j = 0; j < n; j++){
            for(int i = 0; i < m; i++){
                col[j] = Math.max(col[j],matrix[i][j]);
            }
        }

        for (int i = 0; i < m; i++) {
            if (row[i] == col[minCol[i]]) {
                ans.add(row[i]);
            }
        }

        return ans;
    }
}
