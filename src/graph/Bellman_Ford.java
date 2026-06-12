package graph;

import java.util.Arrays;

public class Bellman_Ford {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist,100000000);
        dist[src] = 0;
        for(int i = 1; i <= V-1; i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if(dist[u] != 100000000 && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if(dist[u] != 100000000 && dist[u] + wt < dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }
}
