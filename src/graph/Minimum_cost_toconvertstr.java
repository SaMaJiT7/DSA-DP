package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Minimum_cost_toconvertstr {
//    long[][] adjmatrix;
//    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
//        this.adjmatrix = new long[26][26];
//        for(long[] row : adjmatrix){
//            Arrays.fill(row,Integer.MAX_VALUE);
//        }
//
//        floydwarshall(adjmatrix,original,changed,cost);
//
//        int l = source.length();
//        long mincost = 0;
//        for(int i = 0; i < l; i++){
//            char s = source.charAt(i);
//            char t = target.charAt(i);
//            if(s == t){
//                mincost += 0;
//            }
//            else{
//                if(adjmatrix[s-'a'][t-'a'] == Integer.MAX_VALUE){
//                    return -1;
//                }
//                mincost += adjmatrix[s-'a'][t-'a'];
//            }
//        }
//        return mincost;
//    }
//    public void floydwarshall(long[][] adjmatrix, char[] original, char[] changed, int[] cost){
//
//        for(int i = 0; i < original.length; i++){
//            int u = original[i] - 'a';
//            int v = changed[i] - 'a';
//
//            if((long) cost[i] < adjmatrix[u][v]) {
//                adjmatrix[u][v] = (long) cost[i];
//            }
//        }
//
//        for(int k = 0; k < 26; k++){
//            for(int i = 0; i < 26; i++){
//                for(int j = 0; j < 26; j++){
//                    adjmatrix[i][j] = Math.min(adjmatrix[i][j],adjmatrix[i][k]+adjmatrix[k][j]);
//                }
//            }
//        }
//    }

    long[][] adjmatrix;
    static final long INF = Long.MAX_VALUE / 4;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        this.adjmatrix = new long[26][26];
        for(long[] row : adjmatrix){
            Arrays.fill(row, INF);
        }
        List<int[]>[] adj = new ArrayList[26];
        for(int i = 0; i < 26; i++){
            adj[i] = new ArrayList<>();
        }


        for(int i = 0; i < original.length; i++){
            int u = original[i]- 'a';
            int v = changed[i] - 'a';
            adj[u].add(new int[]{v,cost[i]});
        }

        for (int i = 0; i < 26; i++) {
            dijkstra((char) (i + 'a'), adj, adjmatrix);
        }
        int l = source.length();
        long mincost = 0;
        for(int i = 0; i < l; i++){
            char s = source.charAt(i);
            char t = target.charAt(i);
            if(s == t){
                mincost += 0;
            }
            else{
                if (adjmatrix[s-'a'][t-'a'] >= INF){
                    return -1;
                }
                mincost += adjmatrix[s-'a'][t-'a'];
            }
        }
        return mincost;
    }

    public void dijkstra(char source, List<int[]>[] adj,long[][] adjmatrix){
        int src = source - 'a';

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.add(new int[]{src, 0});
        adjmatrix[src][src] = 0;

        while (!pq.isEmpty()) {
            int[] data = pq.poll();
            int node = data[0];
            int currCost = data[1];

            if (currCost > adjmatrix[src][node]) continue;

            for (int[] next : adj[node]) {
                int neighbour = next[0];
                int edgeCost = next[1];

                long newCost = currCost + edgeCost;
                if (newCost < adjmatrix[src][neighbour]) {
                    adjmatrix[src][neighbour] = newCost;
                    pq.add(new int[]{neighbour, (int) newCost});
                }
            }
        }
    }
}
