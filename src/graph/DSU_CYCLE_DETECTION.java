package graph;

public class DSU_CYCLE_DETECTION {
    int[] parent;
    int[] rank;
    public boolean isCycle(int V, int[][] edges){
       this.parent = new int[V];
       this.rank = new int[V];
        for(int i = 0; i < V; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            int parent_u = find(u);
            int parent_v = find(v);

            if(parent_u == parent_v) return true;
            union(u,v);
        }
        return false;
    }
    public int find(int i){
        if(parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    public void union(int x, int y){
        int parent_x = find(x);
        int parent_y = find(y);
        if(parent_x == parent_y) return;
        if(rank[parent_x] > rank[parent_y]) {
            parent[parent_y] = parent_x;
        }
        else if(rank[parent_y] > rank[parent_x]){
            parent[parent_x] = parent_y;
        }
        else{
            parent[parent_x] = parent_y;
            rank[parent_y]++;
        }
    }
}
