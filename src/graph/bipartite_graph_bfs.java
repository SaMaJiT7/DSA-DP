package graph;

import java.util.*;

public class bipartite_graph_bfs {
    public boolean isBipartite(int V, int[][] edges) {
        int[] color = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        Arrays.fill(color,-1);
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
                if (!BFS(adj, curr, color, 1))
                    return false;
            }
        }
        return true;
    }
    public boolean BFS(List<List<Integer>> adj,int curr, int[] color , int currcolor){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(curr);
        color[curr] = currcolor;

        while(!que.isEmpty()){
            int u = que.poll();

            for(int v : adj.get(u)){
                if(color[v] == color[u]) return false;

                if(color[v] == -1){
                    color[v]  = 1 - color[u];
                    que.add(v);
                }
            }
        }
        return true;
    }
}
