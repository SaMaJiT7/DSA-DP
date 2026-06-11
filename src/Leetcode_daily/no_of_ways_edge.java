package Leetcode_daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class no_of_ways_edge {
    static int mod = 1000000007;
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length+1;
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited,false);
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adjlist.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }
        int depth = dfs(1,adjlist,visited,0);

        return (int)pow(2,depth-1);
    }
    public int dfs(int u,List<List<Integer>> adjlist,boolean[] visited,int depth){
        int val = depth;
        visited[u] = true;


        for(int v : adjlist.get(u)){
            if(!visited[v]){
                val = Math.max(val,dfs(v,adjlist,visited,depth+1));
            }
        }

        return val;
    }

    public long pow(long a, long b){
        if(b == 0) return 1;
        long half = pow(a, b/2);
        long result = half * half % mod;

        if(b % 2 == 1){
            result = (result * a) % mod;
        }

        return result;
    }

}
