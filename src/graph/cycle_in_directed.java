package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cycle_in_directed {
    public boolean isCyclic(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        boolean[] inrecursion = new boolean[V];
        Arrays.fill(visited,false);
        Arrays.fill(inrecursion,false);
        List<List<int[]>> adjlist = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adjlist.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adjlist.get(u).add(new int[]{v});
        }

        for(int i = 0; i < V; i++){
            if(!visited[i] && cycledfs(adjlist,i,visited,inrecursion)){
                return true;
            }
        }
        return false;
    }
    public boolean cycledfs(List<List<int[]>> adj,int u,boolean[] visited,boolean[] inrecursion){
        visited[u] = true;
        inrecursion[u] = true;

        for(int[] edge : adj.get(u)){
            int v = edge[0];
            if(!visited[v] && cycledfs(adj,v,visited,inrecursion)){
                return false;
            }
            else if(inrecursion[v]){
                return false;
            }
        }
        inrecursion[u] = false;
        return true;
    }
}
