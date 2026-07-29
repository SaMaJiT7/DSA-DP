package Binary_Lifting;

import java.util.Arrays;

public class path_exists_Graph {
    int LOG;
    int n;
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        this.n = n;
        this.LOG = 18;
        int[][] sortedArr = new int[n][2];
        for(int i = 0; i < n; i++){
            sortedArr[i][0] = nums[i];
            sortedArr[i][1] = i;
        }
        Arrays.sort(sortedArr,(a,b) -> Integer.compare(a[0],b[0]));
        int[] pos = new int[n];
        for(int i = 0; i < n; i++){
            pos[sortedArr[i][1]] = i;
        }

        int[][] up = new int[n][LOG];
        int far = 0;
        for(int node = 0; node < n; node++){
            while(far < n && sortedArr[far][0] - sortedArr[node][0] <= maxDiff){
                far++;
            }
            up[node][0] = far - 1;
        }
        for(int j = 1; j < LOG; j++) {
            for(int i = 0; i < n; i++){
                if(up[i][j-1] != -1){
                    up[i][j] = up[up[i][j-1]][j-1];
                }
            }
        }
        int q = queries.length;
        int[] ans = new int[q];
        for(int i = 0; i < q; i++){
            int u = queries[i][0];
            int v = queries[i][1];

            int pos_u = pos[u];
            int pos_v = pos[v];

            int start = Math.min(pos_u,pos_v);
            int end = Math.max(pos_u,pos_v);

            if(start == end){
                ans[i] = 0;
                continue;
            }

            int steps = 0;
            for(int j = LOG-1; j >= 0; j--){
                if(up[start][j] < end){
                    start = up[start][j];
                    steps += (1 << j);
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
