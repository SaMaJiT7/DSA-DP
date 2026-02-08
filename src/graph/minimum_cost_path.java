package graph;

import java.util.*;

public class minimum_cost_path {
//    public int minCost(int n, int[][] edges) {
//        Map<Integer, List<Pair>> adj = new HashMap<>();
//
//        for(int[] edge : edges){
//            int u = edge[0];
//            int v = edge[1];
//            int wt = edge[2];
//
//            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, wt));
//            adj.computeIfAbsent(v,k -> new ArrayList<>()).add(new Pair(u,2*wt));
//        }
//        PriorityQueue<Pair> pq = new PriorityQueue<>();
//        int[] result = new int[n];
//        Arrays.fill(result,Integer.MAX_VALUE);
//        result[0] = 0;
//        pq.add(new Pair(0,0));
//
//        while(!pq.isEmpty()){
//            Pair current = pq.poll();
//            int d = current.wt;       // Current total distance so far
//            int node = current.vertex;
//
//            // OPTIMIZATION: Skip stale entries
//            if (d > result[node]) continue;
//
//            if(node == n-1){
//                return result[n-1];
//            }
//
//            for (Pair p : adj.getOrDefault(node, Collections.emptyList())) {
//                int neighbor = p.vertex;
//                int dist = p.wt;
//
//                if(d + dist < result[neighbor]){
//                    result[neighbor] = d + dist;
//                    pq.add(new Pair(neighbor,d + dist));
//                }
//            }
//        }
//        return -1;
//    }
//   static class Pair implements Comparable<Pair>{
//        int vertex;
//        int wt;
//
//
//        public  Pair(int v, int w){
//            this.vertex = v;
//            this.wt = w;
//        }
//
//        @Override
//        public int compareTo(Pair Other) {
//            return Integer.compare(this.wt,Other.wt);
//        }
//    }

    public int minCost(int n, int[][] edges) {
        List<int[]>[] adj = new List[n];

        for(int[] edge : edges){
            if(adj[edge[0]] == null) adj[edge[0]] = new ArrayList<>();
            if(adj[edge[1]] == null) adj[edge[1]] = new ArrayList<>();

            adj[edge[0]].add(new int[]{edge[1],edge[2]});
            adj[edge[1]].add(new int[]{edge[0], 2*edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        int[] result = new int[n];
        Arrays.fill(result,Integer.MAX_VALUE);
        result[0] = 0;
        pq.add(new int[]{0, 0});


        while(!pq.isEmpty()){
            int[] data = pq.poll();
            int node = data[0];
            int wt = data[1];

            if (wt > result[node]) continue;

            if(node == n-1){
                return wt;
            }

            List<int[]> list = adj[node];

            if(list != null){
                for(int[] next : list){
                    int neighbour = next[0];
                    int w = next[1];

                    if(w + wt < result[neighbour]) {
                        result[neighbour] = w + wt;
                        pq.add(new int[]{neighbour, w + wt});
                    }
                }
            }
        }
        return -1;
    }
}
