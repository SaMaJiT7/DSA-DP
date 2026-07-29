package Leetcode_daily;

import java.util.Arrays;
import java.util.List;

public class Number_ofPaths_Min_Score {
    static int mod = (int) (1000000007);
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][] maxscore = new int[n+1][n+1];
        int[][] path_total = new int[n+1][n+1];
        for(int[] row : maxscore){
            Arrays.fill(row,-1);
        }
        for(int[] row : path_total){
            Arrays.fill(row,0);
        }
        maxscore[n-1][n-1] = 0;
        path_total[n-1][n-1] = 1;

        for(int i = n-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(i == n-1 && j == n-1) continue;
                char element = board.get(i).charAt(j);

                if(element == 'X'){
                    continue;
                }
                int current_score = (element == 'E') ? 0 : (element - '0');

                int[][] neighbours = {{i+1,j},{i,j+1},{i+1,j+1}};

                for(int[] ngbr : neighbours){
                    int newi = ngbr[0];
                    int newj = ngbr[1];

                    if(newi >= n || newj >= n || maxscore[newi][newj] == -1){
                        continue;
                    }

                    int candidate_score = maxscore[newi][newj] + current_score;

                    if(candidate_score > maxscore[i][j]){
                        maxscore[i][j] = candidate_score;
                        path_total[i][j] = (path_total[newi][newj]) % mod;
                    }
                    else if(candidate_score == maxscore[i][j]){
                        path_total[i][j] = (path_total[i][j] + path_total[newi][newj]) % mod;
                    }
                }
            }
        }
        if(maxscore[0][0] == -1){
            return new int[]{0,0};
        }

        return new int[]{maxscore[0][0],path_total[0][0]};
    }
}
