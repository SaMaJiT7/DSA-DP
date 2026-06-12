package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class min_cost_to_connect {
    boolean[] inMST;
    int sum;

    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        this.inMST = new boolean[V];
        this.sum = 0;
        Arrays.fill(inMST,false);
        List<List<int[]>> adjlist = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjlist.add(new ArrayList<>());
        }
        //Forming the adjlist.
        for(int i = 0; i < V; i++){
            for(int j = i+1; j < V; j++){
                int dist = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);

                adjlist.get(i).add(new int[]{j,dist});
                adjlist.get(j).add(new int[]{i,dist});
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0,0}); //storing in form of {cost/dist,dest}
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int w = node[0];
            int u = node[1];

            if(inMST[u]) continue;

            inMST[u] = true;
            sum += w;
            for(int[] neighbour : adjlist.get(u)){
                int v = neighbour[0];
                int wt = neighbour[1];

                if(!inMST[v]){
                    pq.add(new int[]{wt,v});
                }
            }
        }
        return sum;
    }
}
