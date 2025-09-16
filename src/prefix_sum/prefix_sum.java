package prefix_sum;

import java.util.Scanner;

public class prefix_sum {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] arr = {
                {0,1,2,3},
                {1,2,3,0},
                {5,4,0,1}};
        prefix_2D(arr);
//        prefixsum(arr);
    }

//    public static void prefixsum(int[] arr){
//        int result = 0;
//        int[] prefix = new int[arr.length];
//
//        prefix[0] = arr[0];
//
//        for(int i = 1; i < prefix.length; i++){
//            prefix[i] = prefix[i-1] + arr[i];
//        }
//        for(int i = 0 ; i < prefix.length;i++){
//            System.out.println(prefix[i]+" ");
//        }
//        int q = sc.nextInt();
//        while(q-- > 0){
//            int l = sc.nextInt();
//            int r = sc.nextInt();
//            result = result + prefix[r] - ((l == 0) ? prefix[l] : prefix[l-1]);
//            System.out.println(result);
//        }
//    }

    public static void prefix_2D(int[][] arr){
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] prefix_2D = new int[n][m];
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                prefix_2D[i][j] = arr[i][j];
                if(i>0){
                    prefix_2D[i][j] += prefix_2D[i-1][j];
                }
                if(j > 0){
                    prefix_2D[i][j] += prefix_2D[i][j-1];
                }
                if(i > 0 && j > 0) {
                    prefix_2D[i][j] -= prefix_2D[i - 1][j - 1];
                }
            }
        }
        int q = sc.nextInt();
        while(q-- > 0){
            System.out.println("Enter the l1 and r1: ");
            int l1 = sc.nextInt();
            int r1 = sc.nextInt();
            System.out.println("Enter the l2 and r2: ");
            int l2 = sc.nextInt();
            int r2 = sc.nextInt();
            int ans = prefix_2D[l2][r2];
            if(l1 > 0){
                ans = ans - prefix_2D[l1-1][r2];
            }
            if(r1 > 0){
                ans = ans - prefix_2D[l2][r1-1];
            }
            if(l1 > 0 && r1 > 0){
                ans += prefix_2D[l1-1][r1-1];
            }
            System.out.println(ans);
        }
    }


}
