package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class cycle_detection_BFS {
    public boolean isCyclic(int V, int[][] edges) {
        Queue<Integer> que = new ArrayDeque<>();
        List<List<int[]>> adj = new ArrayList<>();
        int visitedcount = 0;
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(new int[]{v});
            indegree[v]++;
        }

        for(int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                que.add(i);
                visitedcount++;
            }
        }

            while(!que.isEmpty()){
                int u = que.poll();
                for(int [] edge : adj.get(u)){
                    int v = edge[0];
                    indegree[v]--;


                    if(indegree[v] == 0){
                        que.add(v);
                        visitedcount++;
                    }
                }
            }
        return visitedcount < V;
    }
}
