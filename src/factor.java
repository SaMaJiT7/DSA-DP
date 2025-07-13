import java.awt.*;
import java.util.ArrayList;

public class factor {
    public static void main(String[] args) {
        //O(N)
        factors3(36);
//        for (int i = 1; i <= n; i++) {
//            if(n % i == 0){
//                System.out.print(i + " ");
//            }
//        }
        //System.out.println("\nThe Below one is of complexity O(sqrt(n))");
        System.out.println("\nThe Below one is of Both Space and Time complexity O(sqrt(n))");
    }
//    public static void factors2(int n){
//            // O(sqrt(N))
//            for (int i = 1; i <= Math.sqrt(n); i++) {
//                if (n % i == 0) {
//                    if (n / i == i) {
//                        System.out.print(i);
//                    } else {
//                        System.out.print(i + " " + n / i + " ");
//                    }
//                }
//            }
//        }

    public static void factors3(int n){
        ArrayList<Integer> List = new ArrayList<>();
        // O(sqrt(N))
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    System.out.print(i+ " ");
                } else {
                    System.out.print(i + " ");
                    List.add(n/i);
                }
            }
        }
        for (int i = List.size()-1; i >= 0 ; i--) {
            System.out.print(List.get(i)+ " ");
        }
    }
}

