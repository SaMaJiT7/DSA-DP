package Leetcode_daily;

import java.util.Arrays;
import java.util.List;

public class minScore_pathtotal {
    int max_score = 0;
    int total_path = 0;
    static int mod = 1000000007;
    Pair[][] dp = new Pair[101][101];
    int n;
    public int[] pathsWithMaxScore(List<String> board) {
        this.n = board.size();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = new Pair(-1,-1);
            }
        }
        Pair ans = solve(board,n-1,n-1);
        return new int[]{ans.maxscore,ans.totalpath};
    }
    public Pair solve(List<String> board,int i,int j){
        if(board.get(i).charAt(j) == 'E'){
            return new Pair(0,1);
        }
        if(board.get(i).charAt(j) == 'X'){
            return new Pair(0,0);
        }
        if(dp[i][j].maxscore != -1 && dp[i][j].totalpath != -1){
            return new Pair(dp[i][j].maxscore,dp[i][j].totalpath);
        }
        int upscore = 0; int uppath = 0;
        int leftscore = 0; int leftpath = 0;
        int diagonalscore = 0; int diagonalPath = 0;

        char current = board.get(i).charAt(j);
        //finding value from Up
        if(isValid(i-1,j,board)){
            Pair up = solve(board,i-1,j);
            upscore = up.maxscore;
            uppath = up.totalpath;

            if(uppath > 0){
                upscore += current == 'S' ? 0 : current - '0';
            }
        }
        //finding value from left
        if(isValid(i,j-1,board)){
            Pair left = solve(board,i,j-1);
            leftscore = left.maxscore;
            leftpath = left.totalpath;

            if(leftpath > 0){
                leftscore += current == 'S' ? 0 : current - '0';
            }
        }

        //finding Value from Diagonal
        if(isValid(i-1,j-1,board)){
            Pair diagonal = solve(board,i-1,j-1);
            diagonalscore = diagonal.maxscore;
            diagonalPath = diagonal.totalpath;

            if(diagonalPath > 0){
                diagonalscore += current == 'S' ? 0 : current - '0';
            }
        }


        int bestScore; int bestPath;
        if(upscore == leftscore && leftscore == diagonalscore){
            bestScore = leftscore;
            bestPath = uppath + leftpath + diagonalPath;
        }
        else if(upscore == leftscore){
            bestScore = leftscore;
            bestPath = leftpath + uppath;

            if((diagonalscore == bestScore && diagonalPath > bestPath) || diagonalscore > bestScore){
                bestScore = diagonalscore;
                bestPath = diagonalPath;
            }
        }
        else if(leftscore == diagonalscore){
            bestScore = leftscore;
            bestPath = diagonalPath + leftpath;

            if(upscore > bestScore || (upscore == bestScore && uppath > bestPath)){
                bestScore = upscore; bestPath = uppath;
            }
        }
        else{
            bestScore = upscore;
            bestPath = uppath;
            if(leftscore > bestScore || (leftscore == bestScore && leftpath > bestPath)){
                bestScore = leftscore;
                bestPath = leftpath;
            }
        }

        return dp[i][j] = new Pair(bestScore,bestPath % mod);
    }
    public boolean isValid(int ni, int nj,List<String> board){
        if(ni >= 0 && ni < n && nj >= 0 && nj < n && board.get(ni).charAt(nj) != 'X'){
            return true;
        }
        return false;
    }

    class Pair{
        int maxscore;
        int totalpath;
        public Pair(int maxscore,int totalpath){
            this.maxscore = maxscore;
            this.totalpath = totalpath;
        }
    }
}
