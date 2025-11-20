package Adhoc_problems;

import java.util.Scanner;

public class multiples_od_two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] A = new int[n];
        for(int i = 0; i < n; i++){
            A[i] = sc.nextInt();
        }

        long maxi = 32;
        while(q-- > 0){
            long x = sc.nextLong();

            if(x >= maxi){
                continue;
            }
            maxi = x;
            for(int i = 0; i < n; i++){
                if((A[i] & ((1L << x) - 1)) == 0){
                    A[i] += (int)((1L << x) - 1);
                }
            }
        }

        for(int i = 0; i < n; i++){
            System.out.println(A[i]);
        }
    }
}
