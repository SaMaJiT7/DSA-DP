package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bipartite_graph {
    public boolean isBipartite(int V, int[][] edges) {
        int[] color = new int[V];
        Arrays.fill(color,-1);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int curr = 0; curr < V; curr++){
            if(color[curr] == -1) {
                if(!DFS(adj, curr, color, 1)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean DFS(List<List<Integer>> adj, int curr,int[] color, int currcolour){
        color[curr] = currcolour;

        for(int v : adj.get(curr)){
            if(color[v] == color[curr]) return false;

            if(color[v] == -1) {
                int nextcolor = 1 - color[curr];

                if(!DFS(adj,v,color,nextcolor)){
                    return false;
                }
            }
        }
        return true;
    }
}
