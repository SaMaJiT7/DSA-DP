package BackTracking;

public class word_search {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(board[i][j] == word.charAt(0)){
                   boolean ans = helper(i,j,word,board);
                   if(ans){
                       return true;
                   }
                }
            }
        }
        return false;
    }
    static boolean helper(int r , int c , String word ,char[][] board){
        int m = board.length;
        int n = board[0].length;
        if(word.length() == 0){
            return true;
        }
        if(r >= m || r < 0 || c >= n || c < 0 || board[r][c] != word.charAt(0)){
            return false;
        }

        char ch = board[r][c];
        board[r][c] = '*';
        String s = word.substring(1);
        boolean ans = false;
        for(int i = 0; i < 4; i++){
            int nr = r + dx[i];
            int nc = c + dy[i];
            ans = ans || helper(nr,nc,s,board);  // Changed to OR to fix overwriting
        }
        board[r][c] = ch;
        return ans;
    }
}
