package BackTracking;

public class soduko_solve {
    public void solveSudoku(char[][] board) {
        boolean ans = helper(board , 0 , 0);
    }

    static boolean helper(char[][] board,int r, int c){
        if(r >= board.length){
            return true;
        }
        if(c >= board[0].length){
            return helper(board,r+1,0);
        }
        if(board[r][c] != '.'){
            return helper(board,r,c+1);
        }
        for(char ch = '1'; ch < '9'; ch++){
            if(check(board,r,c,ch)){
                continue;
            }
            board[r][c] = ch;
            boolean ans = helper(board,r,c+1);

            if(ans){
                return ans;
            }
            board[r][c] = '.';
        }
        return false;
    }
    static boolean check(char[][] board , int r , int c , char ch){
        for(int i = 0; i < board[0].length; i++){
            if(board[r][i] == ch){
                return false;
            }
        }
        for(int j = 0; j < board.length; j++){
            if(board[j][c] == ch){
                return false;
            }
        }
        int r1 = r - (r % 3);
        int c1 = c - (c % 3);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == ch){
                    return false;
                }
            }
        }
        return true;
    }
}
