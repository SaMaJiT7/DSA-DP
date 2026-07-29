package graph;

import java.util.regex.Pattern;

public class provinices {
    int[] parent;
    int[] rank;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    union(i,j);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(parent[i] == i){
                ans++;
            }
        }
        return ans;
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
