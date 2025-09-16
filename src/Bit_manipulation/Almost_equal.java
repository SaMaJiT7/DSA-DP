package Bit_manipulation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Almost_equal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            for (int i = 1; i <= 61; i++) {
                long num = (1L << i);
                Set<Long> remainder = new HashSet<>();

                for (long value : arr) {
                    remainder.add(value % num);
                }
                if (remainder.size() == 2) {
                    System.out.println(num);
                    break;
                }
            }
        }
    }
}
