package DP_Tree;

import java.util.*;

public class safeWalk {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
//        int m = grid.size();
//        int n = grid.get(0).size();
//        ArrayDeque<int[]> queue = new ArrayDeque<>();
//        int[][] maxhealthpoint = new int[m][n];
//        for(int[] row : maxhealthpoint) {
//            Arrays.fill(row,-1);
//        }
//        if(grid.getFirst().getFirst() == 1){
//            health -= 1;
//        }
//        queue.add(new int[]{0,0,health});
//        maxhealthpoint[0][0] = health;
//
//        while(!queue.isEmpty()){
//            int[] curr = queue.poll();
//            int r = curr[0];
//            int c = curr[1];
//            int currHealth = curr[2];
//            if(r == m-1 && c == n-1 && currHealth >= 1){
//                return true;
//            }
//            for(int i = 0; i < 4; i++){
//                int nr = r + dx[i];
//                int nc = c + dy[i];
//
//                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
//                    int newhealth = currHealth - grid.get(nr).get(nc);
//                    if(newhealth >= 1 && newhealth > maxhealthpoint[nr][nc]){
//                        maxhealthpoint[nr][nc] = newhealth;
//
//                        if(grid.get(nr).get(nc) == 0){
//                            queue.addFirst(new int[]{nr,nc,newhealth});
//                        }
//                        else{
//                            queue.addLast(new int[]{nr,nc,newhealth});
//                        }
//                    }
//                }
//            }
//        }
//        return false;
        int m = grid.size();
        int n = grid.getFirst().size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[2],a[2]));
        int[][] maxhealthpoint = new int[m][n];
        for(int[] row : maxhealthpoint){
            Arrays.fill(row,-1);
        }
        if(grid.getFirst().getFirst() == 1){
            health -= 1;
        }
        pq.add(new int[]{0,0,health});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int currHealth = curr[2];

            if(r == m-1 && c == n-1 && currHealth >= 1){
                return true;
            }

            for(int i = 0; i < 4; i++){
                int nr = r + dx[i];
                int nc = c + dy[i];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    int newHealth = currHealth - grid.get(nr).get(nc);

                    if(newHealth >= 1 && newHealth > maxhealthpoint[nr][nc]){
                        maxhealthpoint[nr][nc] = newHealth;
                        pq.add(new int[]{nr,nc,newHealth});
                    }
                }
            }
        }
        return false;
    }
}
