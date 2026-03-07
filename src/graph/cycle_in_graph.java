package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cycle_in_graph {
    public boolean isCycle(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited,false);
        List<List<int[]>> adjlist = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adjlist.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjlist.get(u).add(new int[]{v});

            adjlist.get(v).add(new int[]{u});
        }
        for(int i = 0; i < V; i++) {
            if(!visited[i] && solve(adjlist, i, visited, -1)){
                return true;
            }
        }
        return false;
    }
    public boolean solve(List<List<int[]>> adj, int u, boolean[] visited, int parent){
        visited[u] = true;

        for(int[] edge : adj.get(u)){
            int v = edge[0];
            if(v == parent){
                continue;
            }
            if(visited[v]) return true;

            if(solve(adj,v,visited,u)) return true;
        }
        return false;
    }
}
