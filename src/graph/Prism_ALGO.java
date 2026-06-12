package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prism_ALGO {
    boolean[] inMST;
    int sum;
    public int spanningTree(int V, int[][] edges) {
      this.inMST = new boolean[V];
      this.sum = 0;
      List<List<int[]>> adjlist = new ArrayList<>();
      for(int i = 0; i < V; i++){
          adjlist.add(new ArrayList<>());
      }
      for(int[] edge : edges){
          int u = edge[0];
          int v = edge[1];
          int wt = edge[2];

          adjlist.get(u).add(new int[]{v,wt});
          adjlist.get(v).add(new int[]{u,wt});
      }
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
      pq.add(new int[]{0,0});
      while(!pq.isEmpty()){
          int[] node = pq.poll();
          int u = node[1];
          int w = node[0];

          if(inMST[u]) {
              continue;
          }

          inMST[u] = true;
          sum += w;
          for(int[] v : adjlist.get(u)){
              int neighbour = v[0];
              int wt = v[1];

              if(!inMST[neighbour]){
                  pq.add(new int[]{wt,neighbour});
              }
          }
      }
      return sum;
    }
}
