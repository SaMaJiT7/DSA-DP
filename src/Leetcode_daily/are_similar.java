package Leetcode_daily;

public class are_similar {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                int pos = (j + k) % n;
                if(mat[i][pos] != mat[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
