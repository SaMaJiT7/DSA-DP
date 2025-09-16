package prefix_sum;

import java.util.Arrays;
import java.util.Scanner;

public class Kuriyama_stones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        long[] original = new long[n+1];
        for(int i = 1; i <= n; i++){
            original[i] = sc.nextLong();
        }


        long[] sorted = new long[n+1];
        for(int i = 1; i <= n; i++){
            sorted[i] = original[i];
        }
        Arrays.sort(sorted, 1, n+1);


        long[] prefixOriginal = new long[n+1];
        long[] prefixSorted = new long[n+1];

        for(int i = 1; i <= n; i++){
            prefixOriginal[i] = prefixOriginal[i-1] + original[i];
            prefixSorted[i] = prefixSorted[i-1] + sorted[i];
        }

        int m = sc.nextInt();
        while(m-- > 0){
            int type = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            long rangeSum;
            if(type == 2){
                rangeSum = prefixSorted[r] - prefixSorted[l-1];
            } else {
                rangeSum = prefixOriginal[r] - prefixOriginal[l-1];
            }

            System.out.println(rangeSum);
        }

        sc.close();
    }
}
