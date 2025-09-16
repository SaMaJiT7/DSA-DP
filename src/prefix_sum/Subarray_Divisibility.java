package prefix_sum;

import java.util.HashMap;
import java.util.Scanner;

public class Subarray_Divisibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();

        int[] arr = new int[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }

        int[] prefix = new int[n+1];
        int[] remain = new int[n+1];

        prefix[0] = 0;

        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i-1] + arr[i];
            remain[i] = ((prefix[i] % n) + n) % n;
        }


        for(int i = 0; i <= n; i++){
            map.put(remain[i], map.getOrDefault(remain[i], 0) + 1);
        }


        long result = 0;
        for(int count : map.values()){
            result += (long)count * (count - 1) / 2;
        }

        System.out.println(result);
        sc.close();

    }
}
