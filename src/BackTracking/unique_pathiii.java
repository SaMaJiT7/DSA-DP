package BackTracking;

import java.util.Arrays;

public class unique_pathiii {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(boolean[] row : vis){
            Arrays.fill(row,false);
        }
        int cnt = 0;
        int r = 0,c =0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(grid[i][j] == 1){
                    r= i ; c = j;
                }
                if(grid[i][j] == 0) {
                    cnt++;
                }
            }
        }
        //int ans = helper(r,c,cnt,grid);
        int ans1 = helper(r,c,cnt,grid,vis);
        return ans1;
    }
    static int helper(int r, int c, int count, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == -1){
            return 0;
        }
        if(grid[r][c] == 2){
            return (count == -1) ? 1 : 0;
        }
        int temp = grid[r][c];
        grid[r][c] = -1;
        int ans = 0;
        for(int i = 0; i < 4; i++){
            ans += helper(r+dx[i],c+dy[i],count-1,grid);
        }
        grid[r][c] = temp;
        return ans;
    }
    static int helper(int r, int c, int count, int[][] grid,boolean[][] vis){
        int n = grid.length;
        int m = grid[0].length;
        if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == -1 || vis[r][c] == true){
            return 0;
        }
        if(grid[r][c] == 2){
            return (count == -1) ? 1 : 0;
        }
        vis[r][c] = true;
        int ans = 0;
        for(int i = 0; i < 4; i++){
            ans += helper(r+dx[i],c+dy[i],count-1,grid);
        }
        vis[r][c] = false;
        return ans;
    }
}
