package range_query;

public class minimum_cost_bw_indices {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] closet = new int[n];
        closet[0] = 1;
        closet[n-1] = n-2;

        for(int i = 1; i < n-1; i++){
            int left = Math.abs(nums[i] - nums[i-1]);
            int right = Math.abs(nums[i] - nums[i+1]);
            if(left <= right){
                closet[i] = i-1;
            }
            else{
                closet[i] = i+1;
            }
        }

        long[] prefix1 = new long[n];
        prefix1[0] = 0;
        for(int i = 1; i < n; i++){
            if(closet[i-1] == i) {
                prefix1[i] = prefix1[i - 1] + 1;
            }
            else{
                prefix1[i] = prefix1[i - 1] + nums[i] - nums[i-1];
            }
        }

        long[] prefix2 = new long[n];
        prefix2[n-1] = 0;
        for(int i = n-2; i >= 0 ; i--){
            if(closet[i+1] == i){
                prefix2[i] = prefix2[i+1] + 1;
            }
            else{
                prefix2[i] = prefix2[i+1] + nums[i+1] - nums[i];
            }
        }

        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            if(l < r) {
                ans[i] = (int) (prefix1[r] - prefix1[l]);
            }
            else{
                ans[i] = (int) (prefix2[r] - prefix2[l]);
            }
        }
        return ans;
    }
}
