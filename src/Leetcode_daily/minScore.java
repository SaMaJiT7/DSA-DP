package Leetcode_daily;

import java.util.*;

public class minScore {
//    int n;
//    int MinScore = Integer.MAX_VALUE;
//    public int minScore(int n, int[][] roads) {
//        this.n = n;
//        List<List<int[]>> adjlist = new ArrayList<>();
//        boolean[] visited = new boolean[n+1];
//        Arrays.fill(visited,false);
//        for(int i = 1; i <= n; i++){
//            adjlist.add(new ArrayList<>());
//        }
//        for(int[] road : roads) {
//            int u = road[0];
//            int v = road[1];
//            int dist = road[2];
//
//            adjlist.get(u).add(new int[]{v, dist});
//            adjlist.get(v).add(new int[]{u, dist});
//        }
//
//        dfs(adjlist,1,visited);
//
//        return MinScore;
//    }
//    public void dfs(List<List<int[]>> adjlist,int u,boolean[] visited){
//        visited[u] = true;
//
//        for(int[] ngbr : adjlist.get(u)){
//            int v = ngbr[0];
//            int d = ngbr[1];
//
//            MinScore = Math.min(MinScore,d);
//            if(visited[v]) continue;
//            dfs(adjlist,v,visited);
//        }
//    }

    public int minScore(int n, int[][] roads) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        List<List<int[]>> adjlist = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adjlist.add(new ArrayList<>());
        }
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int d = road[2];

            adjlist.get(u).add(new int[]{v,d});
            adjlist.get(v).add(new int[]{u,d});
        }
        int MinScore = Integer.MAX_VALUE;
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int u = queue.poll();

            for(int[] ngbr : adjlist.get(u)){
                int v = ngbr[0];
                int dist = ngbr[1];

                MinScore = Math.min(MinScore,dist);

                if(!visited[v]){
                    queue.offer(v);
                    visited[v] = true;
                }
            }
        }

        return MinScore;
    }
}
