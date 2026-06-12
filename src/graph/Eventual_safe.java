package graph;

import java.util.*;

public class Eventual_safe {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] outdegree = new int[V];
        Arrays.fill(outdegree,0);
        Queue<Integer> queue = new ArrayDeque<>();
        List<List<int[]>> adjlist = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < V; i++) adjlist.add(new ArrayList<>());
        for(int i = 0; i < V; i++){
           for(int v : graph[i]){
               adjlist.get(v).add(new int[]{i});
               outdegree[i]++;
           }
        }

        for(int i = 0; i < V; i++){
            if(outdegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            answer.add(node);

            for(int[] neighbour : adjlist.get(node)){
                int v = neighbour[0];
                outdegree[v]--;

                if(outdegree[v] == 0){
                    queue.add(v);
                }
            }
        }
        Collections.sort(answer);

        return answer;
    }
}
