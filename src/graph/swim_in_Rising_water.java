package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class swim_in_Rising_water {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    int n;
    int m;
    public int swimInWater(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        int[][] result = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0],b[0]));
        for(int[] row : result){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        result[0][0] = grid[0][0];
        pq.add(new int[]{grid[0][0],0,0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int t = node[0];
            int u = node[1];
            int v = node[2];

            if(t > result[u][v]) continue;

            if(u == n-1 && v == m-1){
                return result[u][v];
            }

            for(int i = 0; i < 4; i++) {
                int newU = u + dx[i];
                int newV = v + dy[i];

                if(newU >= 0 && newU < n && newV >= 0 && newV < m){
                    int t1 = grid[newU][newV];
                    int maxt = Math.max(t,t1);


                    if(result[newU][newV] > maxt){
                        result[newU][newV] = maxt;
                        pq.add(new int[]{maxt,newU,newV});
                    }
                }
            }
        }
        return 0;
    }
}
