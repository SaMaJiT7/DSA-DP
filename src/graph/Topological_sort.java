package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Topological_sort {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<int[]>> adjlist = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> result = new Stack<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited,false);
        for(int i = 0; i < V; i++){
            adjlist.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjlist.get(u).add(new int[]{v});
        }
        for(int i = 0; i < V; i++){
            if(!visited[i]) solvedfs(adjlist,i,visited,result);
        }
        while(!result.isEmpty()){
            ans.add(result.pop());
        }
        return ans;
    }
    public void solvedfs(List<List<int[]>> adj,int u,boolean[] visited,Stack<Integer> result){
        visited[u] = true;
        for(int[] edge : adj.get(u)){
            int v = edge[0];
            if(!visited[v]){
                solvedfs(adj,v,visited,result);
            }
        }
        result.add(u);
    }
}
