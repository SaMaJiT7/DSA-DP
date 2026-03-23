package Leetcode_daily;

import java.util.TreeMap;
import java.util.TreeSet;

public class minAbsDiff {
    int k;
    public int[][] minAbsDiff(int[][] grid, int k) {
        this.k = k;
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m-k+1][n-k+1];

        for(int i = 0; i <= m-k; i++){
            for(int j = 0; j <= n-k; j++){
                ans[i][j] = solve(grid,i,j);
            }
        }
        return ans;
    }
    public int solve(int[][] grid,int a,int b){
        TreeMap<Integer,Integer> arr = new TreeMap<>();
        for(int i = a; i < a+k; i++){
            for(int j = b; j < b+k; j++){
                    arr.put(grid[i][j],arr.getOrDefault(grid[i][j],0)+1);
            }
        }
        int diff = Integer.MAX_VALUE;
        Integer prev = null;
        for(int val : arr.keySet()){
            if(prev != null){
                diff = Math.min(diff,val-prev);
            }
            prev = val;
        }
        return diff == Integer.MAX_VALUE ? 0 : diff;
    }
}
