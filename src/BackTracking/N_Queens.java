package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {
    public List<List<String>> solveNQueens(int n){
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row,'.');
        }
        List<List<String>> Nqueen = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        helper(Nqueen,board,0,n);
        return Nqueen;
    }

    static void helper(List<List<String>> Nqueen,char[][] board,int row, int n){
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] rows : board) {
                temp.add(new String(rows));
            }
            Nqueen.add(temp);
            return;
        }

        for(int col = 0; col < board[0].length; col++){
            if(!check(board, row, col, n)){
                continue;
            }
            board[row][col] = 'Q';
            helper(Nqueen,board,row+1,n);
            board[row][col] = '.';
        }

    }
    static boolean check(char[][] board,int row,int col,int n){
        // check column above
         for (int i = 0; i < row; i++) {
                if (board[i][col] == 'Q') return false;
         }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
}
