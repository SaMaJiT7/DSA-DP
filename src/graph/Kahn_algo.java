package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Kahn_algo {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        int[] indegree = new int[V];
        Queue<Integer> que = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        List<List<int[]>> adjlist = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adjlist.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjlist.get(u).add(new int[]{v});
            indegree[v]++;
        }

        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                que.add(i);
            }
        }

        while(!que.isEmpty()){
            int u = que.poll();
            ans.add(u);

            for(int[] edge : adjlist.get(u)){
                int v = edge[0];
                indegree[v]--;


                if(indegree[v] == 0){
                    que.add(v);
                }
            }
        }
        return ans;
    }
}
