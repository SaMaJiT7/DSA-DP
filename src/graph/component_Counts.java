package graph;

import java.util.*;

public class component_Counts {
    boolean[] visited;

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adjlist = new ArrayList<>();
        this.visited = new boolean[n];
        Arrays.fill(visited, false);
        int result = 0;

        for (int i = 0; i < n; i++) {
            adjlist.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] v = {0};
                int[] e = {0};
                //dfs(adjlist,i,v,e);
                bfs(adjlist,i,v,e);
                if ((v[0] * (v[0] - 1)) == e[0]) {
                    result += 1;
                }
            }
        }
        return result;
    }

    private void bfs(List<List<Integer>> adjlist,int u, int[] vertex,int[] edge){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited[u] = true;
        while(!queue.isEmpty()){
            int v = queue.poll();
            vertex[0]++;
            edge[0] += adjlist.get(v).size();
            for(int ngbr : adjlist.get(v)){
                if(!visited[ngbr]){
                    queue.add(ngbr);
                    visited[ngbr] = true;
                }
            }
        }
    }
    //    public void dfs(List<List<Integer>> adjlist, int u,int[] vertexCount,int[] edgeCount){
//        visited[u] = true;
//        vertexCount[0]++;
//        edgeCount[0] += adjlist.get(u).size();
//        for(int ngbr : adjlist.get(u)){
//            if(!visited[ngbr]){
//                dfs(adjlist,ngbr,vertexCount,edgeCount);
//            }
//        }
//    }
}
