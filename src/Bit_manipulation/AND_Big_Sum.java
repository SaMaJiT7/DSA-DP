package Bit_manipulation;

import java.util.Scanner;

public class AND_Big_Sum {
    static long mod = 1000000007L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t ; i++){
            long n = sc.nextLong();
            long k = sc.nextLong();
            System.out.println(helper(n,k));
        }

    }
    public static long helper(long n, long k) {
        long ans = 1;
        n %= mod;
        while (k > 0) {
            if ((k & 1) == 1) {
                ans = (ans * n) % mod;
            }
            n = (n * n) % mod;
            k >>= 1;
        }
        return ans;
    }

}
