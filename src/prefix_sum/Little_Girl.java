package prefix_sum;

import java.util.Arrays;
import java.util.Scanner;

public class Little_Girl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }


        int[] diff = new int[n];
        for(int i = 0; i < q; i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            l--;
            r--;
            diff[l]++;
            if(r+1 < n) {
                diff[r + 1]--;
            }
        }


        for(int i = 1; i < n; i++){
            diff[i] = diff[i - 1] + diff[i];
        }


        Arrays.sort(arr);
        Arrays.sort(diff);


        long result = 0;
        for(int i = 0; i < n; i++){
            result += (long)arr[i] * diff[i];
        }

        System.out.println(result);
        sc.close();
    }
}
