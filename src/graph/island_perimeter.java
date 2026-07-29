package graph;

import java.util.Arrays;

public class island_perimeter {
    int n;
    int m;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public int islandPerimeter(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(boolean[] row : visited) Arrays.fill(row,false);
        int perimeter = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    perimeter += dfs(grid,i,j,visited);
                }
            }
        }
        return perimeter;
    }
    public int dfs(int[][] grid,int x,int y,boolean[][] visited){
        visited[x][y] = true;
        int perimeter = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] == 0){
                perimeter++;
            }
        }
        return perimeter;
    }
}
