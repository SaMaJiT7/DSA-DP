package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class courses_scII_DFS {
    boolean hascycle = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] inrecursion = new boolean[numCourses];
        Stack<Integer> result = new Stack<>();
        Arrays.fill(visited,false);
        Arrays.fill(inrecursion,false);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            int u = edge[1];
            int v = edge[0];
            adj.get(u).add(v);
        }
        for(int i = 0; i  < numCourses; i++){
            if(!visited[i]) DFS(adj,visited,inrecursion,i,result);
        }
        if(hascycle) return new int[]{};
        int i = 0;
        while(!result.isEmpty()){
            ans[i++] = result.pop();
        }
        return ans;
    }
    public void DFS(List<List<Integer>> adj,boolean[] visited,boolean[] inrecursion,int u,Stack<Integer> st){
        visited[u] = true;
        inrecursion[u] = true;

        for(int v : adj.get(u)){

            if(inrecursion[v]){
                hascycle = true;
                return;
            }

            if(!visited[v]){
                DFS(adj,visited,inrecursion,v,st);
            }
        }
        st.push(u);
        inrecursion[u] = false;
    }
//    public boolean iscycle(List<List<Integer>> adj,boolean[] visited,boolean[] inrecursion,int u){
//        visited[u] = true;
//        inrecursion[u] = true;
//        for(int v : adj.get(u)){
//            if(!visited[v] && iscycle(adj,visited,inrecursion,v)){
//                return true;
//            }
//            else if(inrecursion[v]){
//                return true;
//            }
//        }
//        inrecursion[u] = false;
//        return false;
//    }
//    public void toposort(List<List<Integer>> adj, boolean[] visited, int u, Stack<Integer> st){
//        visited[u] = true;
//        for(int v : adj.get(u)){
//            if(!visited[v]){
//                toposort(adj,visited,v,st);
//            }
//        }
//        st.add(u);
//    }
}
