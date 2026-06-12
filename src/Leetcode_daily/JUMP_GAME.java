package Leetcode_daily;

import java.util.Arrays;

public class JUMP_GAME {
    boolean[] visited;
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        this.visited = new boolean[n];
        Arrays.fill(visited,false);
        return solve(arr,n,start);
    }
    public boolean solve(int[] arr,int n,int i){
        visited[i] = true;
        if(arr[i] == 0) return true;

        boolean leftpossible = (i - arr[i] >= 0 && !visited[i-arr[i]] && solve(arr, n, i - arr[i]));
        boolean rightpossible = (i+arr[i] < n && !visited[i+arr[i]] && solve(arr,n,i+arr[i]));


        return leftpossible || rightpossible;
    }
}
