package RECURSION;

import java.util.Scanner;

public class matimum_pathsum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] grid = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int ans = solve(grid,0,0,N,M);
        System.out.println(ans);
    }
    public static int solve(int[][] grid, int i, int j,int n, int m){
        if(i == n-1 && j == m-1){
            return grid[i][j];
        }
        if(i < n-1){
            if(j < m-1){
                return Math.max(solve(grid,i+1,j,n,m)+grid[i][j],solve(grid,i,j+1,n,m)+grid[i][j]);
            }
            else{
                return solve(grid,i+1,j,n,m)+grid[i][j];
            }
        }
        else{
            return solve(grid,i,j+1,n,m)+grid[i][j];
        }
    }
}
