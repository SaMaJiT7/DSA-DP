package graph;

import java.util.*;

public class shortestpath_BnaryMatrix {
//    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
//    static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};
//    public int shortestPathBinaryMatrix(int[][] grid) {
//        int m = grid[0].length;
//        int n = grid.length;
//        if(m == 0 || grid[0][0] != 0) return -1;
//        if(n == 1) return 1;
//        if(grid[n-1][m-1] != 0) return -1;
//        int[] src = new int[]{0,0};
//        int count = 0;
//        Queue<int[]> queue = new ArrayDeque<>();
//        queue.add(src);
//        grid[0][0] = 1;
//
//        while(!queue.isEmpty()){
//            int N = queue.size();
//            while(N-- > 0) {
//                int[] node = queue.poll();
//                int x = node[0];
//                int y = node[1];
//                if (x == n - 1 && y == m - 1) return count + 1;
//
//                for (int i = 0; i < 8; i++) {
//                    int nx = x + dx[i];
//                    int ny = y + dy[i];
//
//                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 0) {
//                            queue.add(new int[]{nx, ny});
//                            grid[nx][ny] = 1;
//                    }
//                }
//            }
//            count++;
//        }
//        return -1;
//    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dirs = {{0,1},{1,1},{1,0}, {1,-1}, {0,-1},{-1,-1},{-1,0},{-1,1}};
        int n = grid.length;
        int m = grid[0].length;
        if(m == 0 || grid[0][0] != 0) return -1;
        if(n == 1) return 1;
        if(grid[n-1][m-1] != 0) return -1;
        int[][] result = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        for(int[] row : result){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        result[0][0] = 0;
        pq.add(new int[]{0,0,0});      // formed in {dist,(x,y)}
        grid[0][0] = 1;

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int d = node[0];
            int x = node[1];
            int y = node[2];

            if(d > result[x][y]) continue;

            for(int[] dir : dirs){
                int nx = x + dir[0];
                int ny = y + dir[1];

                int dist = 1;

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 0 && d + dist < result[nx][ny]) {
                    pq.add(new int[]{d+dist,nx,ny});
                    result[nx][ny] = d+dist;
                    grid[nx][ny] = 1;
                }
            }
        }
        if(result[n-1][m-1] == Integer.MAX_VALUE) return -1;

        return result[n-1][m-1]+1;
    }
}
