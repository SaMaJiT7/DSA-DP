package BackTracking;

public class Wordexist {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int len;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.len = word.length();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    char prev = board[i][j];
                    board[i][j] = '0';

                    if(solve(board,0,word,i,j)) return true;

                    board[i][j] = prev;
                }
            }
        }
        return false;
    }
    private boolean solve(char[][] board,int idx,String word,int x, int y){
        if(x < 0 || x >= m || y < 0 || y >= n || board[x][y] != word.charAt(idx)){
            return false;
        }
        if(idx == len-1){
            return true;
        }

        char prev = board[x][y];
        board[x][y] = '0';

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            char nextChar = word.charAt(idx + 1);
            if (solve(board, idx + 1, word, nx, ny)) return true;
        }
        board[x][y] = prev;
        return false;
    }
}
