package Leetcode_daily;

public class spiral_matrix {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int i = 0;
        int j;
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int k = 1;
        while(k <= n*n){
            //Traverse right
            j = left;
            while(j <= right){
                ans[top][j] = k;
                j++;
                k++;
            }
            top++;

            //traverse Down
            i = top;
            while(i <= bottom){
                ans[i][right] = k;
                i++;
                k++;
            }
            right--;

            //Traverse left
            j = right;
            while(j >= left){
                ans[bottom][j] = k;
                j--;
                k++;
            }
            bottom--;

            //Traverse Up
            i = bottom;
            while(i >= top){
                ans[i][left] = k;
                i--;
                k++;
            }
            left++;
        }
        return ans;
    }
}
