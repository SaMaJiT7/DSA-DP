package Leetcode_daily;

import java.util.*;

public class safest_path {
//    public int maximumSafenessFactor(List<List<Integer>> grid) {
//        int n = grid.size();
//        Queue<int[]> queue = new LinkedList<>();
//        int[][] dist = new int[n][n];
//        int[] dx = {0,0,1,-1};
//        int[] dy = {1,-1,0,0};
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                if(grid.get(i).get(j) == 1){
//                    queue.add(new int[]{i,j});
//                    dist[i][j] = 0;
//                }
//                else{
//                    dist[i][j] = -1;
//                }
//            }
//        }
//        while(!queue.isEmpty()){
//            int[] cell = queue.poll();
//            int r = cell[0];
//            int c = cell[1];
//            for(int i = 0; i < 4; i++){
//                int nr = r + dx[i];
//                int nc = c + dy[i];
//                if((nr >= 0 && nr < n && nc >= 0 && nc < n) && dist[nr][nc] == -1){
//                    dist[nr][nc] = dist[r][c] + 1;
//                    queue.add(new int[]{nr,nc});
//                }
//            }
//        }
//
//        int[][] maxsafepath = new int[n][n];
//        for(int[] row : maxsafepath){
//            Arrays.fill(row,-1);
//        }
//
//        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b) -> Integer.compare(b[2],a[2]));
//        maxsafepath[0][0] = dist[0][0];
//        maxheap.add(new int[]{0,0,dist[0][0]});
//        while(!maxheap.isEmpty()){
//            int[] curr = maxheap.poll();
//            int r = curr[0];
//            int c = curr[1];
//            int SourceSafe = curr[2];
//
//            // Optimization: If we reached the destination, we found our optimal path!
//            if (r == n - 1 && c == n - 1) {
//                return SourceSafe;
//            }
//                if (SourceSafe < maxsafepath[r][c]) continue;
//
//            for(int i = 0; i < 4; i++){
//                int nrow = r + dx[i];
//                int ncol = c + dy[i];
//                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n) {
//                    int newsafe = Math.min(SourceSafe,dist[nrow][ncol]);
//
//                    if (newsafe > maxsafepath[nrow][ncol]) {
//                        maxsafepath[nrow][ncol] = newsafe;
//                        maxheap.add(new int[]{nrow, ncol,newsafe});
//                    }
//                }
//            }
//        }
//        return 0;
//    }

    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,-1,1};
public int maximumSafenessFactor(List<List<Integer>> grid) {
    int n = grid.size();
    int[][] safe = new int[n][n];
    Queue<int[]> queue = new LinkedList<>();
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(grid.get(i).get(j) == 1){
                queue.add(new int[]{i,j});
                safe[i][j] = 0;
            }
            else{
                safe[i][j] = -1;
            }
        }
    }
    while(!queue.isEmpty()){
        int[] curr = queue.poll();
        int r = curr[0];
        int c = curr[1];
        for(int i = 0; i < 4; i++){
            int nr = r + dx[i];
            int nc = c + dy[i];
            if(nr >= 0 && nr < n && nc >= 0 && nc < n && safe[nr][nc] == -1){
                safe[nr][nc] = safe[r][c] + 1;
                queue.add(new int[]{nr,nc});
            }
        }
    }
    int low = 0;
    int high = 2*n;
    int ans = 0;
    while(low <= high){
        int sf = low + (high-low)/2;

        if(check(sf,safe)){
            ans = sf;
            low = sf+1;
        }
        else{
            high = sf - 1;
        }
    }
    return ans;
}
public boolean check(int sf,int[][] safe){
    int n = safe.length;
    if (safe[0][0] < sf || safe[n - 1][n - 1] < sf) {
        return false;
    }
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[n][n];
    queue.add(new int[]{0,0});
    visited[0][0] = true;

    while(!queue.isEmpty()){
        int[] curr = queue.poll();
        int r = curr[0];
        int c = curr[1];

        if(r == n-1 && c == n-1){
            return true;
        }
        for(int i = 0; i < 4; i++){
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && safe[nr][nc] >= sf ){
                visited[nr][nc] = true;
                queue.add(new int[]{nr,nc});
            }
        }
    }
    return false;
}
}
