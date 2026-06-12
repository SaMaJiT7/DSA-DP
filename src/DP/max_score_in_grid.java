package DP;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class max_score_in_grid {

    long[][][] t = new long[2][101][101];
    int n;
    public long maximumScore(int[][] grid) {
        this.n = grid.length;

        for(long[][] row : t){
            for(long[] vals : row){
                Arrays.fill(vals,-1);
            }
        }

        long[][] prefixcol = new long[n+1][n+1];

        for(int i = 0; i < n+1; i++){
            prefixcol[0][i] = 0;
            prefixcol[i][0] = 0;
        }

        for(int j = 1; j <= n; j++){
            for(int i = 1; i <= n; i++){
                prefixcol[i][j] = prefixcol[i-1][j] + grid[i-1][j-1];
            }
        }

        return solve(0,0,grid,0,prefixcol); // false = 0 , true = 1
    }
    public long solve(int prevused,int col,int[][] grid,int Prevheight,long[][] prefixcol){
        if(col == n){
            return 0;
        }
        long result = 0;

        for(int h = 0; h <= n; h++){
            long prevColscore = 0;
            long currColscore = 0;
            if(t[prevused][Prevheight][col] != -1){
                return t[prevused][Prevheight][col];
            }
            if(prevused == 0 && h > Prevheight && col-1 >= 0){
                prevColscore += (prefixcol[h][col] - prefixcol[Prevheight][col]);
            }
            if(Prevheight > h){
                currColscore += (prefixcol[Prevheight][col+1] - prefixcol[h][col+1]);
            }

            long currColScoreTaken = currColscore + prevColscore + solve(1,col+1,grid,h,prefixcol);

            long currColScoreNotTaken = prevColscore + solve(0,col+1,grid,h,prefixcol);

            result = Math.max(result,Math.max(currColScoreTaken,currColScoreNotTaken));
        }
        return t[prevused][Prevheight][col] = result;
    }
}
