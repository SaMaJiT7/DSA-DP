package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class shortest_path_kconsecutive {
    int n;
    int k;
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        this.n = n;
        this.k = k;
        List<List<int[]>> adjlist = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjlist.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int W = edge[2];

            adjlist.get(u).add(new int[]{v,W});
        }
        int[][] dist = new int[n][k+1];
        for(int[] row : dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        pq.add(new int[]{0,0,1});// storing like node, weight to reach this node, no of consecutive elements before
        dist[0][1] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int w = curr[1];
            int Currconsecutivelabel = curr[2];

            if(u == n-1) return w;
            dist[u][Currconsecutivelabel] = w;
            if(w > dist[u][Currconsecutivelabel]){
                continue;
            }

            for(int[] ngbr : adjlist.get(u)){
                int v = ngbr[0];
                int wt = ngbr[1];
                int consecutivelabel;
                if(labels.charAt(v) != labels.charAt(u)){
                    consecutivelabel = 1;
                }
                else{
                    consecutivelabel = Currconsecutivelabel + 1;
                }
                if(consecutivelabel <= k){
                    if(w + wt < dist[v][consecutivelabel]){
                        dist[v][consecutivelabel] = w + wt;
                        pq.add(new int[]{v,w+wt,consecutivelabel});
                    }
                }
            }
        }
       return -1;
    }
}
