package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class count_pairs_DSU {
    int[] parent;
    int[] rank;
    public long countPairs(int n, int[][] edges) {
        this.parent = new int[n];
        this.rank = new int[n];
        Arrays.fill(rank,1);
        int[] nodecount = new int[n];
        long result = 0;
        int total = n;
        for(int i = 0; i < n; i++) parent[i] = i;

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            union(u,v);
        }
        for(int i = 0; i < n; i++){
            int parent = find(i);
            nodecount[parent]++;
        }
        for(int i = 0; i < nodecount.length; i++){
            int size = nodecount[i];
            if(size != 0) {
                result += (long) size * (total - size);
                total = total - size;
            }
        }
        return result;
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
            rank[parent_x]++;
        }
    }
}
