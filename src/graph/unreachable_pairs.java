package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class unreachable_pairs {
    public long countPairs(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
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
            if(!visited[i]) {
                nodes.add(bfs(adj, i, visited));
            }
        }
        for(int i = 0; i < nodes.size(); i++){
            ans += (long) nodes.get(i) * (n-nodes.get(i));
            n = n - nodes.get(i);
        }
        return ans;
    }
    public int bfs(List<List<Integer>> adj,int i, boolean[] visited){
        int count = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        visited[i] = true;
        queue.add(i);

        while(!queue.isEmpty()){
            int u = queue.poll();

            for(int v : adj.get(u)){
                if(!visited[v]){
                    visited[v] = true;
                    queue.add(v);
                    count++;
                }
            }
        }
        return count;
    }
}
