package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class count_pairs {
    public long countPairs(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> nodes = new ArrayList<>();
        long ans = 0;
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
               nodes.add(dfs(adj,i,visited));
            }
        }

        for(int i = 0; i < nodes.size(); i++){
            ans += (long) nodes.get(i) * (n-nodes.get(i));
            n = n - nodes.get(i);
        }
        return ans;
    }
    public int dfs(List<List<Integer>> adj, int u, boolean[] visited){
        int count = 1;
        visited[u] = true;

        for(int v : adj.get(u)){
            if(!visited[v]){
                count = count + dfs(adj,v,visited);
            }
        }
        return count;
    }
}
