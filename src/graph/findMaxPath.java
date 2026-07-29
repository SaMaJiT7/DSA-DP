package graph;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class findMaxPath {
    int n;
    long k;
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        this.n = online.length;
        this.k = k;
        List<List<int[]>> adjlist = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjlist.add(new ArrayList<>());
        }
        int minCost = Integer.MAX_VALUE;
        int maxCost = Integer.MIN_VALUE;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            minCost = Math.min(minCost,cost);
            maxCost = Math.max(maxCost,cost);
            if(!online[u] || !online[v]) continue;
            adjlist.get(u).add(new int[]{v,cost});
        }
        int low = minCost;
        int high = maxCost;

        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(isPossible(adjlist,mid,online)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }

    private boolean isPossible(List<List<int[]>> adjlist, int cost,boolean[] online){
        long[] result = new long[n];
        Arrays.fill(result, Long.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        result[0] = 0;
        pq.add(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0];
            int c = node[1];

            if(c > k) return false;
            if(u == n-1) return true;

            if(c > result[u]) continue;

            for(int[] ngbr : adjlist.get(u)){
                int v = ngbr[0];
                int ct = ngbr[1];

                if(ct >= cost){
                    if(c + ct < result[v]){
                        result[v] = c + ct;
                        pq.add(new int[]{v,c+ct});
                    }
                }
            }
        }
        return false;
    }
}
