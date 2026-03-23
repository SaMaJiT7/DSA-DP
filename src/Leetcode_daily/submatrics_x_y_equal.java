package Leetcode_daily;

public class submatrics_x_y_equal {
//    public int numberOfSubmatrices(char[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        int[][] grid2 = new int[n][m];
//        int[][] Xcount = new int[n][m];
//        if(n == 1 && m == 1) return 0;
//        int ans = 0;
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                if(grid[i][j] == 'X'){
//                    grid2[i][j] = 1;
//                    Xcount[i][j] = 1;
//                }
//                else if(grid[i][j] == 'Y'){
//                    grid2[i][j] = -1;
//                    Xcount[i][j] = 0;
//                }
//                else{
//                    grid2[i][j] = 0;
//                    Xcount[i][j] = 0;
//                }
//            }
//        }
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                if(i > 0){
//                    grid2[i][j] += grid2[i-1][j];
//                    Xcount[i][j] += Xcount[i-1][j];
//                }
//                if(j > 0){
//                    grid2[i][j] += grid2[i][j-1];
//                    Xcount[i][j] += Xcount[i][j-1];
//                }
//                if(i > 0 && j > 0){
//                    grid2[i][j] -= grid2[i-1][j-1];
//                    Xcount[i][j] -= Xcount[i-1][j-1];
//                }
//
//                if(grid2[i][j] == 0 && Xcount[i][j] > 0) ans++;
//            }
//        }
//        return ans;
//    }
public int numberOfSubmatrices(char[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[] colsum = new int[m];
    int[] colX = new int[m];
    int ans = 0;
    for(int i = 0; i < n; i++) {
        int xrunning = 0;
        int runningsum = 0;

        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 'X') {
                colsum[j] += 1;
                colX[j] += 1;
            } else if (grid[i][j] == 'Y') {
                colsum[j] += -1;
            }

            runningsum += colsum[j];
            xrunning += colX[j];

            if (runningsum == 0 && xrunning > 0) ans++;
        }
    }
    return ans;
}
}
