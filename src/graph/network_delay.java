package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class network_delay {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] result = new int[n+1];
        int ans = Integer.MIN_VALUE;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i =  0; i <= n; i++) adj.add(new ArrayList<>());
        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];

            adj.get(u).add(new int[]{v,t});
        }
        Arrays.fill(result,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        result[k] = 0;
        pq.add(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[1];
            int t = node[0];

            if(t > result[u]) continue;

            for(int[] neighbour : adj.get(u)){
                int v = neighbour[0];
                int tn = neighbour[1];

                if(t + tn < result[v]){
                    result[v] = t+tn;
                    pq.add(new int[]{t+tn,v});
                }
            }
        }
        for(int i = 1; i < result.length; i++){
            if(result[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans,result[i]);
        }
        return ans;
    }
}
