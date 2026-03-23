package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class path_with_minimum_effort {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,-1,1};
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] result = new int[rows][cols];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        for(int[] row : result){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        result[0][0] = 0;
        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int diff = node[0];
            int u = node[1];
            int v = node[2];

            if(diff > result[u][v]) continue;

            for(int i = 0; i < 4; i++){
                int newU = u + dx[i];
                int newV = v + dy[i];


                if(newU >= 0 && newU < rows && newV >= 0 && newV < cols){
                    int d = Math.abs(heights[u][v] - heights[newU][newV]);
                    int maxdiff = Math.max(d,diff);


                    if(result[newU][newV] > maxdiff){
                        result[newU][newV] = maxdiff;
                        pq.add(new int[]{maxdiff,newU,newV});
                    }
                }
            }
        }
        return result[rows-1][cols-1];
    }
}
