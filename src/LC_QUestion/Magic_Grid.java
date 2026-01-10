package LC_QUestion;

import java.util.HashSet;

public class Magic_Grid {
    public int numMagicSquaresInside(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int count = 0;
        for(int i = 0; i <= r-3;i++){
            for(int j = 0; j <= c-3;j++){
                if(isMagicGrid(grid,i,j)){
                     count++;
                }
            }
        }
        return count;
    }
    public static boolean isMagicGrid(int[][] grid,int r , int c){
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(grid[r+i][c+j] >= 1 && grid[r+i][c+j] < 10){
                    if(!map.contains(grid[r+i][c+j])){
                        map.add(grid[r+i][c+j]);
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }

        int Rsum = grid[r][c] + grid[r][c+1] + grid[r][c+2];

        for(int i = 0; i < 3; i++){
            //RowSum
            if(grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2] != Rsum){
                return false;
            }
            //ColumnSum
            if(grid[r][c+i]+grid[r+1][c+i]+grid[r+2][c+i] != Rsum){
                return false;
            }
        }

        //diagonalsum
        if(grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2] != Rsum){
            return false;
        }
        if(grid[r+2][c]+grid[r+1][c+1]+grid[r][c+2] != Rsum){
            return false;
        }
        return true;
    }
}
