package Leetcode_daily;

public class canPartitionGrid {
    public boolean canPartitionGrid(int[][] grid) {
         int n = grid.length;
         int m = grid[0].length;
         long Totalsum = 0;
         for(int i = 0; i < n; i++){
             for(int j = 0; j < m; j++){
                 Totalsum += grid[i][j];
             }
         }

         //HorizontalCHECK
        long Hsum = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < m; j++){
                Hsum += grid[i][j];
            }
            if(Hsum == Totalsum-Hsum){
                return true;
            }
        }

        //VerticalCHECK
        long Vsum = 0;
        for(int j = 0; j < m-1; j++){
            for(int i = 0; i < n; i++){
                Vsum += grid[i][j];
            }
            if(Vsum == Totalsum-Vsum){
                return true;
            }
        }

        return false;
    }
}
