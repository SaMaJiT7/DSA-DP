package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class makeConnected {
//    public int makeConnected(int n, int[][] connections) {
//        int V = connections.length;
//        boolean[] visited = new boolean[n];
//        Arrays.fill(visited,false);
//        int components = 0;
//        if(V < n-1) return -1;
//        List<List<Integer>> adj = new ArrayList<>();
//        for(int i = 0; i < n; i++){
//            adj.add(new ArrayList<>());
//        }
//        for(int[] edge : connections){
//            int u = edge[0];
//            int v = edge[1];
//            adj.get(u).add(v);
//            adj.get(v).add(u);
//        }
//        for(int i = 0; i < n; i++){
//            if(!visited[i]){
//                dfs(adj,i,visited);
//                components++;
//            }
//        }
//        return components - 1;
//    }
//    public void dfs(List<List<Integer>> adj,int u,boolean[] visited){
//        if(visited[u]) return;
//        visited[u] = true;
//
//        for(int v : adj.get(u)){
//            if(!visited[v]){
//                dfs(adj,v,visited);
//            }
//        }
//    }

    int[] parent;
    int[] rank;
    public int makeConnected(int n, int[][] connections) {
        int components = n;
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        if(connections.length < n-1) return -1;

        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            int parent_u = find(u);
            int parent_v = find(v);

            if(parent_u != parent_v){
                union(u,v);
                components--;
            }
        }
        return components - 1;
   }
   public int find(int i){
        if(parent[i] == i) return i;
        return parent[i] = find(parent[i]);
   }
   public void union(int x, int y){
        int parent_x = find(x);
        int parent_y = find(y);
        if(parent_x == parent_y) return;
        if(rank[parent_x] > rank[parent_y]){
            parent[parent_y] = parent_x;
        }
        else if(rank[parent_y] > rank[parent_x]){
            parent[parent_x] = parent_y;
        }
        else{
            parent[parent_y] = parent_x;
        }
   }
}
