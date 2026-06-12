package Leetcode_daily;

public class xor_range {
    static int mod = (int) 1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] query : queries){
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            for(int i = l; i <= r; i=i+k){
                nums[i] = (int) (((long) nums[i] * v) % mod);
            }
        }
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            ans = ans ^ nums[i];
        }

        return ans;
    }
}
