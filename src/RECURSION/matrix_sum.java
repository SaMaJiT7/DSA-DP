package RECURSION;

import java.util.Scanner;

public class matrix_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] A = new int[r][c];
        int[][] B = new int[r][c];

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                A[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                B[i][j] = sc.nextInt();
            }
        }
        helper(A,B,r,c,0,0);
    }

    static void helper(int[][] a, int[][] b , int maxrow, int maxcol, int row, int col){
        if(row > maxrow){
            return;
        }
        if(col == maxcol-1){
            System.out.println(a[row][col]+b[row][col]);
            helper(a,b,maxrow,maxcol,row+1,col);
            return;
        }
        System.out.print(a[row][col]+b[row][col]);
        helper(a,b,maxrow,maxcol,row,col+1);
    }
}
