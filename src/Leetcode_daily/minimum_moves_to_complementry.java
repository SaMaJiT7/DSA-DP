package Leetcode_daily;

public class minimum_moves_to_complementry {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2*limit+2];
        for(int i = 0; i < n/2; i++){
            int a = nums[i];
            int b = nums[n-1-i];

            int minval = Math.min(a,b) + 1;
            int maxval = Math.max(a,b) + limit;

            diff[2] += 2;
            diff[2*limit+1] -= 2;

            diff[minval] += (-1);
            diff[maxval+1] -= (-1);

            diff[a+b] += (-1);
            diff[a+b+1] -= (-1);
        }
        int result = Integer.MAX_VALUE;

        for(int sum = 2; sum <= 2*limit; sum++){
            diff[sum] += diff[sum-1];

            result = Math.max(result,diff[sum]);
        }

        return result;
    }
}
