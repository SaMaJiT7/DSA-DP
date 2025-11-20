package GRID_DP;

import java.util.Arrays;

public class maximal_area {
    static int[][] t = new int[1001][1001];
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] t = new int[rows+1][cols+1];
        int maxSide = 0;
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= cols; j++){
                if(matrix[i-1][j-1] == '1'){
                    t[i][j] = Math.min(Math.min(t[i - 1][j], t[i][j - 1]), t[i - 1][j - 1]) + 1;
                    maxSide = Math.max(maxSide,t[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    static int dfs(int i , int j , char[][] matrix , boolean[][] visited){
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length){
            return 0;
        }
        if(matrix[i][j] == '0' || visited[i][j]){
            return 0;
        }
        if(t[i][j] != 1){
            return t[i][j];
        }

        visited[i][j] = true;
        int area = 1;

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        for(int k = 0; k < 4 ; k++){
            area = area + dfs(i+dx[k],j+dy[k],matrix,visited);
        }

        t[i][j] = area;
        return area;
    }
}
