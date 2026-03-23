package Leetcode_daily;

public class rotate_array {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int m = mat[0].length;
        for(int k = 0; k < 4; k++){
            boolean flag = true;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(mat[i][j] != target[i][j]){
                        flag = false;
                        break;
                    }
                }
                if(!flag) break;
            }
            if(flag) return true;
            rotate(mat);
        }
        return false;
    }
    public void rotate(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < m; j++){
               int temp = mat[i][j];
               mat[i][j] = mat[j][i];
               mat[j][i] = temp;
            }
            int k = 0;
            int j = m-1;
            while(k < j){
                int temp = mat[i][k];
                mat[i][k] = mat[i][j];
                mat[i][j] = temp;
                k++;
                j--;
            }
        }
    }
}
