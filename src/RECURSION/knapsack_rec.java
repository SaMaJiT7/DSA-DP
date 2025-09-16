package RECURSION;

import java.util.Scanner;

public class knapsack_rec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int[] wt = new int[N];
        int[] val = new int[N];
        for(int i = 0; i < N ; i++){
            wt[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }
        System.out.println(knapsack(wt,val,W,N));
    }

    static int knapsack(int[] wt, int[] val,int W,int n){
        if(n == 0 || W == 0){
            return 0;
        }

        if(wt[n-1] <= W) {
            int n1 = val[n-1]+knapsack(wt, val, W - wt[n - 1], n - 1);//this case , here we will take the element from the array.
            int n2 = knapsack(wt, val, W, n - 1);// here in this case we didn't take the value from the array in our knapsack.

            return Math.max(n1, n2);
        }
        else {
            return knapsack(wt,val,W,n-1);
        }
    }
}
