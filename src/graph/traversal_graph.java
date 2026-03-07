package graph;

import java.util.*;

public class traversal_graph {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        Arrays.fill(visited,false);



        ArrayList<Integer> ans = new ArrayList<>();
        solve(adj,0,visited,ans);
        return ans;
    }
    public void solve(ArrayList<ArrayList<Integer>> adj, int u,boolean[] visited,ArrayList<Integer> ans){
        if(visited[u]) return;

        visited[u] = true;
        ans.add(u);
        for(Integer edge : adj.get(u)){
            if(!visited[edge]){
                solve(adj,edge,visited,ans);
            }
        }
    }
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        Arrays.fill(visited,false);
        List<List<int[]>> adjlist = new ArrayList<>();
        for(int i = 0; i < adj.size(); i++){
            adjlist.add(new ArrayList<>());
        }
        for(int u = 0 ; u < adj.size(); u++){
            for(int v : adj.get(u)){
                adjlist.get(u).add(new int[]{v});
            }
        }


        ArrayList<Integer> ans = new ArrayList<>();
        solve(adjlist,0,visited,ans);
        return ans;
    }
    public void solve(List<List<int[]>> adj, int u,boolean[] visited,ArrayList<Integer> ans){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(u);
        visited[u] = true;
        ans.add(u);
        while(!que.isEmpty()){
            int u1 = que.poll();
            for(int[] edge : adj.get(u1)){
                int v = edge[0];
                if(!visited[v]){
                    que.add(v);
                    visited[v] = true;
                    ans.add(v);
                }
            }
        }
    }
}
