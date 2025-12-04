package DP_Tree;

import java.util.ArrayList;
import java.util.List;

public class maximum_tree {
    static int count;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for(int[] e : edges){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        count = 0;
        dfs(0, -1, adj, values, k);
        return count;
    }

    static int dfs(int curr, int parent, List<Integer>[] adj, int[] values, int k) {
        int sum = values[curr] % k;

        for(int ngr : adj[curr]){
            if(ngr != parent){
                sum += dfs(ngr, curr, adj, values, k);
                sum %= k;
            }
        }

        if(sum % k == 0){
            count++;
        }

        return sum % k;
    }
}
