package graph;

import java.sql.PreparedStatement;
import java.util.*;
import java.util.stream.Stream;

public class courses_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<int[]>> adj = new ArrayList<>();
        int[] answer = new int[numCourses];
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree,0);
         for(int i = 0; i < numCourses; i++){
             adj.add(new ArrayList<>());
         }
         for(int[] edge : prerequisites){
             int u = edge[1];
             int v = edge[0];
             adj.get(u).add(new int[]{v});
             indegree[v]++;
         }
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)queue.add(i);
        }
        int i = 0;
        while(!queue.isEmpty()){
            int u = queue.remove();
            answer[i++] = u;
            for(int[] edge : adj.get(u)){
                int v = edge[0];
                indegree[v]--;

                if(indegree[v] == 0) queue.add(v);
            }
        }
        return i == numCourses ? answer : new int[]{};
    }
}
