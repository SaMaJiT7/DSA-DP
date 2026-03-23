package Leetcode_daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class find_city {
    int n;
    int dist;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        this.n = n;
        this.dist = distanceThreshold;
        int mincount = Integer.MAX_VALUE;
        int city = -1;
        List<List<int[]>> adj = new ArrayList<>();
        int[] result = new int[n];
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        for(int i = 0; i < n; i++){
            result[i] = dijsktra(adj,i);
        }
        for(int i = 0; i < n; i++){
            if(result[i] < mincount || (result[i] == mincount && i > city)){
                mincount = result[i];
                city = i;
            }
        }
        return city;
    }
    public int dijsktra(List<List<int[]>> adj,int k){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        int[] result = new int[n];
        Arrays.fill(result,Integer.MAX_VALUE);

        result[k] = 0;
        pq.add(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0];
            int w = node[1];

            if(w > result[u]) continue;

            for(int[] neighbour : adj.get(u)){
                int v = neighbour[0];
                int wt = neighbour[1];

                if(w + wt < result[v]){
                    result[v] = w + wt;
                    pq.add(new int[]{v,w+wt});
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(i != k && result[i] <= dist){
                count++;
            }
        }
        return count;
    }
}
