package Leetcode_daily;

import jdk.jshell.StatementSnippet;
import jdk.jshell.execution.JdiExecutionControlProvider;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class assignEdgeWeight_II {
    static int mod = (int) 1000000007;
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        int m = queries.length;
        List<List<Integer>> adjlist = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        int[] answer = new int[m];
        for(int i = 0; i <= n; i++){
            adjlist.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }
        int LOG = (int) (Math.ceil(Math.log(n)/Math.log(2)) + 1);
        int[][] up = new int[n+1][LOG];
        int[] depth = new int[n+1];
        depth[1] = 0;
        for(int[] val : up){
            Arrays.fill(val,-1);
        }
        visited[1] = true;
        dfs(1,adjlist,visited,up,depth);

        for(int j = 1; j < LOG; j++){
            for(int node = 1; node <= n; node++){
                if(up[node][j-1] != -1){
                    up[node][j] = up[up[node][j-1]][j-1];
                }
            }
        }

        for(int i = 0; i < m ; i++){
            int u = queries[i][0];
            int v = queries[i][1];
            int uoriginal = u;
            int voriginal = v;
            int diff = 0;
            if(depth[u] > depth[v]){
                diff = depth[u] - depth[v];
                for(int j = LOG-1; j >= 0; j--){
                    if((diff & (1 << j)) != 0){
                        u = up[u][j];
                    }
                }
            }
            else{
                diff = depth[v] - depth[u];
                for(int j = LOG-1; j >= 0; j--){
                    if((diff & (1 << j)) != 0){
                        v = up[v][j];
                    }
                }
            }
            int lca = 0;
            if(u == v){
                lca = u;
            }
            else{
                for(int j = LOG-1; j >= 0; j--){
                    if(up[u][j] != -1 && up[u][j] != up[v][j]){
                        u = up[u][j];
                        v = up[v][j];
                    }
                }
                lca = up[u][0];
            }
            int len = depth[uoriginal] + depth[voriginal] - 2 * depth[lca];

            if(len == 0){
                answer[i] = 0;
            }
            else{
                answer[i] = (int) power(2,len-1);
            }
        }
        return answer;
    }
    public void dfs(int u, List<List<Integer>> adjlist,boolean[] visited,int [][] up,int[] depth){
        visited[u] = true;

        for(int ngbr : adjlist.get(u)){
            if(!visited[ngbr]) {
                depth[ngbr] = depth[u] + 1;
                up[ngbr][0] = u;
                visited[ngbr] = true;
                dfs(ngbr, adjlist, visited, up, depth);
            }
        }
    }


    public long power(int a, int b){
        if(b == 0){
            return 1;
        }
        long half = power(a,b/2);
        long result = (half * half) % mod;

        if(b % 2 == 1){
            result = (result * a) % mod;
        }

        return result;
    }
}
