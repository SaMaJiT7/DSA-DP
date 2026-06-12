package Leetcode_daily;

public class hasvalidpath {
    int m;
    int n;
    public boolean hasValidPath(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][][] dir = {{{0,0},{0,0}},{{0,1},{0,-1}},{{1,0},{-1,0}},{{0,-1},{1,0}},{{0,1},{1,0}},{{0,-1},{-1,0}},{{0,1},{-1,0}}};

        return dfs(0,0,grid,dir,visited);
    }
    public boolean dfs(int i, int j,int[][] grid,int[][][] dir,boolean[][] visited){
        if(i == m-1 && j == n-1) return true;
        visited[i][j] = true;

        int street = grid[i][j];

        for(int[] d : dir[street]){
            int nx =  i + d[0];
            int ny =  j + d[1];

            boolean canConnect = false;
            if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                if(visited[nx][ny]) continue;
                int newstreet = grid[nx][ny];
                for(int[] check : dir[newstreet]){
                    if(check[0] == -(d[0]) && check[1] == -(d[1])){
                        canConnect = true;
                        break;
                    }
                }
                if(canConnect){
                    if(dfs(nx,ny,grid,dir,visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
