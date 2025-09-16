package Bit_manipulation;

import java.util.Scanner;

public class XORwice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long result = a ^ b;
            System.out.println(result);
        }
    }
    public static void Raising_Bacteria(){
        Scanner scan = new Scanner(System.in);

        long Req = scan.nextLong();
        int answer = Integer.bitCount((int) Req);
        System.out.println(answer);
    }
}
