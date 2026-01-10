package LC_QUestion;

import ALGo_In_Array.Transform_Array;

import java.util.Arrays;

public class leetcode_hard1970 {
    static int ROW ;
    static int COL;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int latestDayToCross(int row, int col, int[][] cells) {
        ROW = row;
        COL = col;
        int lastday = 0;
        int l = 0;
        int r = cells.length - 1;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(canCross(cells, mid)){
                lastday = mid+1;
                l = mid+1;
            }
            else{
                r = mid - 1;
            }
        }
        return lastday;
    }

    public static boolean canCross(int[][] cells, int m){
        int[][] grid = new int[ROW][COL];

        for(int i = 0; i <= m; i++){
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;
            grid[x][y] = 1;
        }
        // Try DFS from first row
        for (int j = 0; j < COL; j++) {
            if (grid[0][j] == 0) {
                if (DFS(grid, 0, j)) return true;
            }
        }
        return false;
    }

    public static boolean DFS(int[][] grid, int i , int j){
        if(i < 0 || i >= ROW || j < 0 || j >= COL || grid[i][j] == 1){
            return false;
        }
        if(i == ROW-1){
            return true;
        }

        grid[i][j] = 1;
        for(int c = 0; c < 4; c++){
            int new_i = i + dx[c];
            int new_j = j + dy[c];

            if(DFS(grid,new_i,new_j)){
                return true;
            }
        }
        return false;
    }
}
