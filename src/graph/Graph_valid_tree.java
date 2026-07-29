package graph;

import java.util.*;

public class Graph_valid_tree {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjlist = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            adjlist.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }
        int components = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]) {
               components++;
               if(components > 1 || solve(adjlist, i, visited)) {
                   return false;
               }
           }
       }
       return true;
    }
    public boolean solve(List<List<Integer>> adjlist,int i,boolean[] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,-1});
        visited[i] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int u = curr[0];
            int parent = curr[1];

            for(int v : adjlist.get(u)){
                if(!visited[v]){
                    queue.add(new int[]{v,u});
                    visited[v] = true;
                }
                else if(v != parent){
                    return true;
                }
            }
        }
        return false;
    }
}
