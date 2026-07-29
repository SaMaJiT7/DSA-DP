package graph;

import java.util.Arrays;

public class path_existence {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr,(a,b) -> Integer.compare(a[0],b[0]));

        int[] rank = new int[n];
        for(int i = 0; i < n; i++){
            rank[arr[i][1]] = i;
        }
        int LOG = 18;
        int[][] up = new int[n][LOG];

        int j = 0;
        for(int i = 0; i < n; i++){
            while(j < n && arr[j][0] - arr[i][0] <= maxDiff){
                j++;
            }
            up[i][0] = j-1;
        }

        for(int k = 1; k < LOG; k++){
            for(int i = 0; i < n; i++){
                if(up[i][k-1] != -1){
                    up[i][k] = up[up[i][k-1]][k-1];
                }
            }
        }

        int q = queries.length;
        int[] ans = new int[q];
        for(int i = 0; i < q; i++){
            int u = queries[i][0];
            int v = queries[i][1];

            int rankU = rank[u];
            int rankV = rank[v];
            int start = Math.min(rankU,rankV);
            int end = Math.max(rankU,rankV);
            if(start == end) {
                ans[i] = 0;
                continue;
            }
            int steps = 0;
            for(int k = LOG-1; k >= 0; k--){
                if(up[start][k] < end){
                    start = up[start][k];
                    steps += (1 << k);
                }
            }

            if(up[start][0] >= end){
                ans[i] = steps + 1;
            }
            else{
                ans[i] = -1;
            }
        }

        return ans;
    }
}
