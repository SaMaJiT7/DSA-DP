package Bit_manipulation;

import java.util.Arrays;
import java.util.Scanner;

public class Two_binary_string {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int pos_x = -1;
            int pos_y = -1;
            String x = sc.next();
            String y = sc.next();
            StringBuilder x1 = new StringBuilder(x);
            StringBuilder y1 = new StringBuilder(y);
             x1.reverse().toString();
             y1.reverse().toString();



            for (int i = 0; i < y.length(); i++) {
                if (y1.charAt(i) == '1') {
                    pos_y = i;
                    break;
                }
            }

            if (pos_y == -1) {
                System.out.println(0);
                continue;
            }


            for (int i = pos_y; i < x.length(); i++) {
                if (x1.charAt(i) == '1') {
                    pos_x = i;
                    break;
                }
            }

            int k = (pos_x == -1) ? 0 : (pos_x - pos_y);
            System.out.println(k);
        }
        sc.close();
    }
}
