package graph;

import java.util.Arrays;

public class min_cost_connect_al_points {
    int[][] edges;
    int[] parent;
    int[] rank;
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        this.edges = new int[V*(V-1)/2][3];
        int e = 0;
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                int wt = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges[e][0] = i;
                edges[e][1] = j;
                edges[e][2] = wt;
                e++;
            }
        }
        this.parent = new int[V];
        this.rank = new int[V];
        for(int i = 0; i < V; i++){
            parent[i] = i;
            rank[i] = 0;
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

            int parent_u = find(u);
            int parent_v = find(v);

            if(parent_u != parent_v){
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
