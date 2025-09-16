package prefix_sum;

import java.util.Scanner;

public class Queries_result {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n+1];
        System.out.println("please enter the elements of the array: ");
        for(int i = 1; i<= n; i++){
            A[i] = sc.nextInt();
        }
        int[] prefix = new int[n+1];
        prefix[0] = 0;
        int[] prefix2 = new int[n+1];
        prefix2[0] = 0;

        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i-1] + (i * A[i]);
            prefix2[i] = prefix2[i-1] + A[i];
        }
        int q = sc.nextInt();
        while(q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println((prefix[r]-prefix[l-1]) - (l-1) * (prefix2[r]-prefix2[l-1]));
        }
    }
}
