package Leetcode_daily;

public class flip_square {
    int m; int n;
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        this.m = grid.length;
        this.n = grid[0].length;

        for(int i = 0; i <= k/2 - 1; i++){
            for(int j = y; j <= y+k-1; j++){
                swap(x+i , x+k-1-i , j , grid);
            }
        }
        return grid;
    }

    public void swap(int fr, int lr, int col,int[][] grid){
        if(fr >= 0 && fr < m && lr  >= 0 && lr < m && col >= 0 && col < n){
            int temp = grid[fr][col];
            grid[fr][col] = grid[lr][col];
            grid[lr][col] = temp;
        }
    }
}
