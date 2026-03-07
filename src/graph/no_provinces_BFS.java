package graph;

import permutation.Questions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class no_provinces_BFS {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                bfs(isConnected,i,visited);
                ans++;
            }
        }
        return ans;
    }
    public void bfs(int[][] isConnected,int u,boolean[] visited){
        Queue<Integer> que = new ArrayDeque<>();
        if(visited[u]) return;
        que.add(u);
        visited[u] = true;

        while(!que.isEmpty()){
            int curr = que.poll();

            for(int v = 0; v < isConnected.length; v++){
                if(!visited[v] && isConnected[curr][v] == 1){
                    visited[v] = true;
                    que.add(v);
                }
            }
        }
    }
}
