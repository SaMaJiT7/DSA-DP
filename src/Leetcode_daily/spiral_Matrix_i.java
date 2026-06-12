package Leetcode_daily;

import java.util.ArrayList;
import java.util.List;

public class spiral_Matrix_i {
        public List<Integer> spiralOrder(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            int i;
            int right = m-1;
            int left = 0;
            int bottom = n-1;
            int top = 0;
            List<Integer> ans = new ArrayList<>();
            while(top <= bottom && left <= right) {
                //Traverse Right
                i = left;
                while (i <= right) {
                    ans.add(matrix[top][i]);
                    i++;
                }
                top++;

                if (top <= bottom) {
                    //Traverse Down
                    i = top;
                    while (i <= bottom) {
                        ans.add(matrix[i][right]);
                        i++;
                    }
                    right--;
                }

                if (top <= bottom) {
                    //Traverse Left
                    i = right;
                    while (i >= left) {
                        ans.add(matrix[bottom][i]);
                        i--;
                    }
                    bottom--;
                }


                if (left <= right) {
                    //Traverse up
                    i = bottom;
                    while (i >= top) {
                        ans.add(matrix[i][left]);
                        i--;
                    }
                    left++;
                }
            }
            return ans;
        }
}
