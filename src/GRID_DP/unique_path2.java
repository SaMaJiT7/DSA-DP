package GRID_DP;

import java.util.Arrays;

public class unique_path2 {
    static int[][] t = new int[101][101];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int max = Integer.MIN_VALUE;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) return 0;

        t[0][0] = 1;
        for(int i = 1; i < n; i++){
            if(obstacleGrid[i][0] == 1) {
                t[i][0] = 0;
            }
            else{
                t[i][0] = t[i-1][0];
            }
        }
        for(int j = 1; j < m; j++){
            if(obstacleGrid[0][j] == 1) {
                t[0][j] = 0;
            }
            else{
                t[0][j] = t[0][j-1];
            }
        }

        for(int i = 1; i < n;i++){
            for(int j = 1; j < m; j++){
                if(obstacleGrid[i][j] == 1){
                    t[i][j] = 0;
                }
                else{
                    t[i][j] = t[i-1][j] + t[i][j-1];
                }
            }
        }

        return t[n-1][m-1];

    }

//        // Initialize start position
//        t[0][0] = 1;
//
//        // Fill the first column
//        for (int i = 1; i < n; i++) {
//            if (obstacleGrid[i][0] == 0)
//                t[i][0] = t[i - 1][0];
//            else
//                t[i][0] = 0;
//        }
//
//        // Fill the first row
//        for (int j = 1; j < m; j++) {
//            if (obstacleGrid[0][j] == 0)
//                t[0][j] = t[0][j - 1];
//            else
//                t[0][j] = 0;
//        }
//public static int countpaths(int i, int j,int[][] obstacleGrid){
//        if(i < 0 || j < 0){
//            return 0;
//        }
//        if(obstacleGrid[i][j] == 1){
//            return 0;
//        }
//        if(i == 0 && j == 0){
//            return 1;
//        }
//
//        int up = countpaths(i-1,j,obstacleGrid);
//        int left = countpaths(i,j-1,obstacleGrid);
//
//        return t[i][j] = up + left;
//    }
}
