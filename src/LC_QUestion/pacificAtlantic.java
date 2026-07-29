package LC_QUestion;

import java.util.*;

public class pacificAtlantic {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    int m;
    int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacificvisted = new boolean[m][n];
        boolean[][] atlanticvisited = new boolean[m][n];
        Queue<int[]> paciQueue = new LinkedList<>();
        Queue<int[]> atlaQueue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            paciQueue.add(new int[]{i,0});
            pacificvisted[i][0] = true;
        }
        for(int j = 1; j < n; j++){
            paciQueue.add(new int[]{0,j});
            pacificvisted[0][j] = true;
        }
        while(!paciQueue.isEmpty()){
            int[] curr = paciQueue.poll();
            int x = curr[0];
            int y = curr[1];
            int currHeight = heights[x][y];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < m && ny >= 0 && ny < n && !pacificvisted[nx][ny] && heights[nx][ny] >= currHeight){
                    paciQueue.add(new int[]{nx,ny});
                    pacificvisted[nx][ny] = true;
                }
            }
        }

        for(int i = 0; i < m; i++){
            atlaQueue.add(new int[]{i,n-1});
            atlanticvisited[i][n-1] = true;
        }
        for(int j = 0; j < n-1; j++){
            atlaQueue.add(new int[]{m-1,j});
            atlanticvisited[m-1][j] = true;
        }

        while(!atlaQueue.isEmpty()){
            int[] curr = atlaQueue.poll();
            int x = curr[0];
            int y = curr[1];
            int currHeight = heights[x][y];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < m && ny >= 0 && ny < n && !atlanticvisited[nx][ny] && heights[nx][ny] >= currHeight){
                    atlaQueue.add(new int[]{nx,ny});
                    atlanticvisited[nx][ny] = true;
                }
            }
        }
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacificvisted[i][j] && atlanticvisited[i][j]){
                    answer.add(Arrays.asList(i,j));
                }
            }
        }
        return answer;
    }
}
