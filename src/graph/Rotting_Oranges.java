package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int minutes = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rottenthisTime = false;
            for(int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid
                            [nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        queue.add(new int[]{nx, ny});
                        rottenthisTime = true;
                    }
                }
            }
            if(rottenthisTime){
                minutes += 1;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return minutes;
    }
}
