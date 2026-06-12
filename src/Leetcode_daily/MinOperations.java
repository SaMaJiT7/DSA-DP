package Leetcode_daily;

import java.util.Arrays;

public class MinOperations {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] nums = new int[m*n];
        int k = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                nums[k++] = grid[i][j];
            }
        }
        int len = nums.length;
        int rem = nums[0] % x;
        for(int i = 1; i < len; i++){
            if(nums[i] % x != rem){
                return -1;
            }
        }
        Arrays.sort(nums);
        int median = nums[len/2];

        int diff = 0;
        for(int i = 0; i < len; i++){
            diff += (Math.abs(nums[i]-median))/x;
        }

        return diff;
    }
}
