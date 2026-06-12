package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class minimum_hamming_dist {
    int[] parent;
    int[] rank;
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        HashMap<Integer, List<Integer>> comp = new HashMap<>();
        int n = source.length;
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int[] edges : allowedSwaps) {
            int u = edges[0];
            int v = edges[1];
            union(u, v);
        }
        for (int i = 0; i < n; i++) {
            int root = find(i);
            comp.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        for (List<Integer> indices : comp.values()) {
            HashMap<Integer, Integer> freqMap = new HashMap<>();
            for (int idx : indices) {
                freqMap.put(source[idx], freqMap.getOrDefault(source[idx], 0) + 1);
            }
            for (int idx : indices) {
                int val = target[idx];
                if(freqMap.getOrDefault(val,0) > 0){
                    freqMap.put(val,freqMap.get(val)-1);
                }
                else{
                    ans++;
                }
            }
        }
        return ans;
    }
    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if(x_parent == y_parent) return;

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }
        else if(rank[y_parent] > rank[x_parent]){
            parent[x_parent] = y_parent;
        }
        else{
            parent[y_parent] = x_parent;
        }
    }
}
