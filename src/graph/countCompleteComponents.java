package graph;

import java.util.Arrays;

public class countCompleteComponents {
    int[] rank;
    int[] parent;
    public int countCompleteComponents(int n, int[][] edges) {
        rank = new int[n];
        parent = new int[n];
        Arrays.fill(rank,0);
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            union(edge[0],edge[1]);
        }
        int [] vertexCount = new int[n];
        int [] edgeCount = new int[n];
        for(int i = 0; i < n; i++){
            int parent_root = find(i);
            vertexCount[parent_root]++;
        }
        for(int[] edge : edges){
            int parent_u = find(edge[0]);
            edgeCount[parent_u]++;
        }
        int connectedComponent = 0;
        for(int i = 0; i < n; i++){
            if(parent[i] == i){
                int v = vertexCount[i];
                int e = edgeCount[i];

                if(e == ((v * (v-1)) / 2)){
                    connectedComponent++;
                }
            }
        }
        return connectedComponent;
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
            rank[parent_x]++;
        }
    }
}
