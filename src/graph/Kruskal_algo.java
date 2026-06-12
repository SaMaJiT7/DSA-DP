package graph;

import java.util.Arrays;

public class Kruskal_algo {
    int[] parent;
    int[] rank;
    public int spanningTree(int V, int[][] edges) {
        this.parent = new int[V];
        this.rank = new int[V];
        for(int i = 0; i < V; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        Arrays.sort(edges,(a,b) -> Integer.compare(a[2],b[2]));
        return Kruskal(edges);
    }
    public int Kruskal(int[][] edges){
        int sum = 0;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            int u_parent = find(u);
            int v_parent = find(v);

            if(u_parent != v_parent){
                union(u,v);
                sum += wt;
            }
        }
        return sum;
    }
    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
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
