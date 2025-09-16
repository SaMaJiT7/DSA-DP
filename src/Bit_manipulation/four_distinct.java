package Bit_manipulation;

import java.util.Scanner;

public class four_distinct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            solve(N);
        }
        sc.close();
    }

    public static void solve(int N) {
        long a = (1L << 36) + (1L << 37);
        long b = (1L << 36);
        long c = (1L << 35);
        long d = (1L << 36) + (1L << 35) + N;
        System.out.println(a + " " + b + " " + c + " " + d);
    }
}
