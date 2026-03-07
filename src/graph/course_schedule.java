package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class course_schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] inrecursion = new boolean[numCourses];
        Arrays.fill(visited,false);
        Arrays.fill(inrecursion,false);
        List<List<int[]>> adjlist = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adjlist.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int u = edge[1];
            int v = edge[0];

            adjlist.get(u).add(new int[]{v});
        }
        for(int i = 0; i < numCourses; i++){
            if(!visited[i] && dfs(adjlist,i,visited,inrecursion)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(List<List<int[]>> adj,int u,boolean[] visited,boolean[] inrecursion){
        visited[u] = true;
        inrecursion[u] = true;

        for(int [] edge : adj.get(u)){
            int v = edge[0];

            if(!visited[v] && dfs(adj,v,visited,inrecursion)){
                return true;
            }
            else if(inrecursion[v]){
                return true;
            }
        }
        inrecursion[u] = false;
        return false;
    }
}
