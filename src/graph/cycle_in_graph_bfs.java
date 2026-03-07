package graph;

import java.util.*;

public class cycle_in_graph_bfs {
    public boolean isCycle(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        List<List<int[]>> adjlist = new ArrayList<>();
        Arrays.fill(visited,false);
        for(int i = 0; i < V; i++){
            adjlist.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adjlist.get(u).add(new int[]{v});

            adjlist.get(v).add(new int[]{u});
        }
        for(int i = 0; i < V; i++){
            if(!visited[i] && solve(adjlist,i,visited)){
                return true;
            }
        }
        return false;
    }
    public boolean solve(List<List<int[]>> adj,int u,boolean[] visited){
        Queue<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(u,-1));
        visited[u] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int node = p.u;
            int parent = p.prev;

            for(int[] vt : adj.get(node)){
                int v = vt[0];
                if(!visited[v]){
                    visited[v] = true;
                    queue.add(new Pair(v,node));
                }
                else if(v != parent){
                    return true;
                }
            }
        }
        return false;
    }
    class Pair{
        int u;
        int prev;
        public Pair(int u, int prev){
            this.u = u;
            this.prev = prev;
        }
    }
}
