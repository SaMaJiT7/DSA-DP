package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dfs_eventual_safe {
//
    boolean[] visited ;
    boolean[] recursion;
    List<List<int[]>> adjlist;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        this.adjlist = new ArrayList<>();
       //this.visited = new int[V];
        this.visited = new boolean[V];
        this.recursion = new boolean[V];
        //Arrays.fill(visited,0);
        Arrays.fill(visited,false);
        Arrays.fill(recursion,false);
        for(int i = 0; i < V; i++) adjlist.add(new ArrayList<>());
        for(int i = 0; i < V; i++){
            for(int node : graph[i]){
                adjlist.get(i).add(new int[]{node});
            }
        }

        for(int i = 0; i < V; i++){
            if(!visited[i])
                dfs(adjlist,i,visited,recursion);
        }
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<V;i++) if(!recursion[i]) ans.add(i);

        return ans;
    }
//    public boolean dfs(List<List<int[]>> adjlist, int u, int[] visited){
//        if(visited[u] == 1) return false;
//        if(visited[u] == 2) return true;
//        visited[u] = 1;
//
//        for(int[] next : adjlist.get(u)){
//            int v = next[0];
//            if(!dfs(adjlist,v,visited)) return false;
//        }
//        visited[u] = 2;
//        return true;
//    }

    public boolean dfs(List<List<int[]>> adjlist, int u, boolean[] visited,boolean[] recursion){
        visited[u] = true;
        recursion[u] = true;

        for(int[] edge : adjlist.get(u)){
            int v = edge[0];
            if(!visited[v] && dfs(adjlist,v,visited,recursion)){
                return true;
            }else if(recursion[v]){
                return true;
            }
        }

        recursion[u] = false;
        return false;
    }

}
