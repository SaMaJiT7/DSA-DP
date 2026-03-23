package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijsktra_IMPLEMENTATION {
    public int[] dijkstra(int V, int[][] edges, int src) {
        int[] result = new int[V];
        List<List<int[]>> adj = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        Arrays.fill(result,Integer.MAX_VALUE);
        result[src] = 0;
        pq.add(new int[]{src,0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0];
            int w = node[1];

            for(int[] neighbour : adj.get(u)){
                int v = neighbour[0];
                int wt = neighbour[1];

                if(w+wt < result[v]){
                    result[v] = w+wt;
                    pq.add(new int[]{v, w + wt});
                }
            }
        }
        return result;
    }

}
