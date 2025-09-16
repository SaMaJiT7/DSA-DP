package Bit_manipulation;

import java.util.Scanner;

public class Fortune_Telling {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() {
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        // f toggles for every even number in arr
        boolean f = false;
        for (int v : arr) {
            if ((v & 1) == 0) { // even
                f = !f;         // toggle
            }
        }

        boolean xOdd = (x & 1) == 1;
        boolean yOdd = (y & 1) == 1;

        // condition: even count of evens (i.e., !f) AND y is odd
        boolean condition = (!f) && yOdd;

        // If x is odd -> Alice when condition true; if x is even -> Alice when condition false
        boolean aliceWins = xOdd ? condition : !condition;

        System.out.println(aliceWins ? "Alice" : "Bob");
    }
}
