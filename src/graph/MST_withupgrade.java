package graph;

import java.util.ArrayList;
import java.util.List;

public class MST_withupgrade {
    int[] parent;
    int[] rank;
    public int maxStability(int n, int[][] edges, int k) {
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int s = edge[2];
            int m = edge[3];

            if(m == 1){
                if(find(u) == find(v)){
                    return -1;
                }
                union(u,v);
            }
        }
        int low = 1;
        int high = (int) (2*1e5);
        int result = -1;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(check(edges,n,k,mid)){
                result = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return result;
    }
    public boolean check(int[][] edges, int n, int k, int mid){
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        List<int[]> Upgrade = new ArrayList<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            int s = edge[2];
            int m = edge[3];

            if(m == 1){
                if(s < mid) return false;
                union(u,v);
            }else {
                if(s >= mid){
                    union(u,v);
                }else if(2*s >= mid){
                    Upgrade.add(new int[]{u,v});
                }
            }
        }
        for(int[] edge : Upgrade){
            int u = edge[0];
            int v = edge[1];

            if(find(u) != find(v)){
                if(k <= 0) return false;

                union(u,v);
                k--;
            }
        }

        int root = find(0);
        for(int i = 1; i < n; i++){
            if(find(i) != root){
                return false;
            }
        }
        return true;
    }
    public int find(int i){
        if(parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    public void union(int x,int y){
        int parent_x = find(x);
        int parent_y = find(y);
        if(parent_y == parent_x) return;

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
