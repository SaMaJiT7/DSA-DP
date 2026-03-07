package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class no_of_provisions {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[isConnected.length];
        Arrays.fill(visited,false);

        int ans = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(isConnected,i,visited);
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int[][] isConnected,int u, boolean[] visited){
        if(visited[u]) return;

        visited[u] = true;
        for(int v = 0; v < isConnected.length; v++){
            if(isConnected[u][v] == 1 && !visited[v]){
                dfs(isConnected,v,visited);
            }
        }
    }
}
