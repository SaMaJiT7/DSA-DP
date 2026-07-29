package graph;

public class pathExistenceQueries {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int m = queries.length;
        boolean[] ans = new boolean[m];
        int[] component = new int[n];
        int grpId = 0;
        component[0] = grpId;
        for(int i = 1; i < n; i++){
            if(nums[i] - nums[i-1] <= maxDiff){
                component[i] = grpId;
            }
            else{
                grpId++;
                component[i] = grpId;
            }
        }

        for(int i = 0; i < m; i++){
            int l = queries[i][0];
            int r = queries[i][1];

            ans[i] = (component[l] == component[r]);
        }

        return ans;
    }
}
