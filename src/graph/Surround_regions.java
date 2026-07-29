package graph;

import java.util.Arrays;

public class Surround_regions {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int m;
    int n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O'){
                dfs(i,0,board);
            }
            if(board[i][n-1] == 'O'){
                dfs(i,n-1,board);
            }
        }

        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O'){
                dfs(0,j,board);
            }
            if(board[m-1][j] == 'O'){
                dfs(m-1,j,board);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'E'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int x, int y,char[][] board){
        board[x][y] = 'E';
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'O'){
                dfs(nx,ny,board);
            }
        }
    }
}
