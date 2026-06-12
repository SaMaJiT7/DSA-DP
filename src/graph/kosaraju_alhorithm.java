package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class kosaraju_alhorithm {
    public int kosaraju(int V, int[][] edges) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited,false);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }
        //calling the topo sort for the order in which the next dfs will call, the order is store in stack st.
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfsfill(i,adj,visited,st);
            }
        }

        //reverse the graph
        List<List<Integer>> reverseadj = new ArrayList<>();
        for(int i = 0 ; i < V; i++) reverseadj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            reverseadj.get(v).add(u);
        }

        //calling the dfs in order of stack present for finding the component.
        int scc = 0;
        Arrays.fill(visited,false);
        while(!st.isEmpty()){
            int u = st.pop();

            if(!visited[u]){
                sccdfs(u,reverseadj,visited);
                scc++;
            }
        }
        return scc;
    }
    public void dfsfill(int u,List<List<Integer>> adj, boolean[] visited,Stack<Integer> st){
        if(visited[u]) return;
        visited[u] = true;
        for(int v : adj.get(u)){
            if(!visited[v]){
                dfsfill(v,adj,visited,st);
            }
        }
        st.push(u);
    }

    public void sccdfs(int u,List<List<Integer>> reverseadj, boolean[] visited){
        visited[u] = true;

        for(int v : reverseadj.get(u)){
            if(!visited[v]){
                sccdfs(v,reverseadj,visited);
            }
        }
    }
}
