package Leetcode_daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class rhombussum {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        ArrayList<Integer> result = new ArrayList<>();
        TreeSet<Integer> ans = new TreeSet<>();
        int[][] prefix = new int[m][n];   // \ diagonal
        int[][] prefix2 = new int[m][n];  // / diagonal


        // build prefix (\ diagonal)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i][j] = grid[i][j] + ((i > 0 && j > 0) ? prefix[i - 1][j - 1] : 0);
            }
        }
        // build prefix2 (/ diagonal)
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                prefix2[i][j] = grid[i][j] + ((i > 0 && j + 1 < n) ? prefix2[i - 1][j + 1] : 0);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans.add(grid[i][j]);
                for(int k = 1; k <= Math.min(Math.min(i,j),Math.min(m-1-i,n-1-j)); k++){
                    if(k == 1) {
                        int val = grid[i - k][j] + grid[i][j - k] + grid[i + k][j] + grid[i][j + k];
                        ans.add(val);
                    }
                    else {
                        int top = i - k;
                        int bottom = i + k;
                        int left = j - k;
                        int right = j + k;
                        int val = 0;

                        // top -> right   (\ diagonal)
                        val += prefix[i][right] - (top > 0 && j > 0 ? prefix[top - 1][j - 1] : 0);

                        // right -> bottom   (/ diagonal)
                        val += prefix2[bottom][j] - (i > 0 && right + 1 < n ? prefix2[i - 1][right + 1] : 0);

                        // left -> bottom   (\ diagonal)
                        val += prefix[bottom][j] - (i > 0 && left > 0 ? prefix[i - 1][left - 1] : 0);

                        // top -> left   (/ diagonal)
                        val += prefix2[i][left] - (top > 0 && j + 1 < n ? prefix2[top - 1][j + 1] : 0);

                        // subtract 4 corners once because they get counted twice
                        val -= grid[top][j];
                        val -= grid[i][right];
                        val -= grid[bottom][j];
                        val -= grid[i][left];

                        ans.add(val);
                    }
                }
            }
        }
        for(int i : ans.descendingSet()){
            result.add(i);
            if(result.size() == 3){
                break;
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}
