package MCM_DP;

import java.util.Arrays;

public class MCM_Memoization {
    static int[][] t = new int[1001][1001];

    public static void main(String[] args) {
        for (int[] row : t) {
            Arrays.fill(row, -1);
       }
        int[] arr = {10,20,30,10,30};
        int i = 1;
        int j = arr.length-1;
        System.out.println(memo_mcm(arr,i,j));
    }

    public static int memo_mcm(int[] arr, int i , int j){
        if(i >= j){
            return 0;
        }

        if(t[i][j] != -1){
            return t[i][j];
        }
        else{
            int min = Integer.MAX_VALUE;
            for(int k = i+1; k <= j ; k++){
                int temp = (memo_mcm(arr,i,k-1) + memo_mcm(arr,k,j)+ (arr[i-1]*arr[k]*arr[j]));

                if(temp < min){
                    min = temp;
                }

            }
            return t[i][j] = min;
        }
    }
}
