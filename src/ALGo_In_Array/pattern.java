package ALGo_In_Array;

import java.util.Scanner;

public class pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int r = sc.nextInt();
//        String str = "";
//////        int totalSpaces = 4-1;
//////        for (int i = 1; i < 4 ; i++){
//////            for (int j = 1 ; j < i ; j++){
//////                System.out.print("");
//////            }
//////            for (int k = 1; k < 2*i; k++){
//////                System.out.print("*");
//////            }
//////            System.out.println("\n");
//////        int n = 3; // Adjust this value to determine the number of rows
//////        for (int i = 1; i <= n; i++) {
//////            for (int j = 0; j < i; j++) {
//////                System.out.print(i + " ");
//////            }
//////            System.out.println();
//////        for (int i = 1; i <= n; i++) {
//////        // Print leading spaces for centering
//////        for (int space = 0; space < totalSpaces; space++) {
//////            System.out.print("   ");
//////        }
//////
//////        // Print the numbers for the current row
//////        for (int j = 1; j <= i; j++) {
//////            System.out.print(i + "   ");
//////        }
//////
//////        // Move to the next line after each row
//////        System.out.println();
//////
//////        // Decrease the total spaces for the next row
//////        totalSpaces--;
//////    }
//        for(int i = 1; i <= r; i++){
//            for(int j = 1; j <= r ; j++){
//                System.out.print(i+ " ");
//            }
//            System.out.println();
//        }
//        for(int i = 1; i <= r; i++){
//                str = str + i;
//                System.out.print(str);
//                System.out.println();
//        }
//        for(int i = 1; i<= r ; i++){
//            for (int j = r; j > i-1 ; j--){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < 2 * r; i++) {
//            int totalcol = i > r ? 2 * r - i : i;
//            for (int j = 0; j < totalcol; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < 2 * r ; i++){
//            int totalcol = i > r ? 2 * r - i :i;
//
//            for(int k = 0; k < r - totalcol; k++){
//                System.out.print(" ");
//            }
//
//            for (int j = 0; j < totalcol; j++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i <= r ; i++){
//           // int totalcol = i > r ? 2 * r - i :i;
//
//            for(int k = 0; k < r - i; k++){
//                System.out.print(" ");
//            }
//
//            for (int j = 0; j < i ; j++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//
//        for (int i = 1; i <= r; i++){
//
//            for (int k = 0; k < r-i ; k++){
//                System.out.print(" ");
//            }
//
//            for (int j = i ; j >= 1 ; j--){
//                System.out.print(j + " ");
//            }
//
//            for (int j = 2; j <= r ; j++){
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }

//        for (int i = 1; i <= r ; i++) {
//            for(int j = 1; j < r -i ;j++){
//                System.out.print("  ");
//            }
//            for (int k = 1; k <= 2*i-1; k++){
//                System.out.print("*"+"  ");
//            }
//            System.out.println(" ");
//        }

//        for (int i = 0; i < 2*r ; i++){
//            int totalcol = i > r ?  r - i :i;
//
//            for(int k = 0; k < r - totalcol; k++){
//                System.out.print(" ");
//            }
//
//            for (int j = 0; j < totalcol; j++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the number of rows for the pyramid: ");
//        int numRows = scanner.nextInt();

//        for (int i = 1; i <= r; i++) {
//            // Print spaces before the asterisks
//            for (int j = 1; j <= r - i; j++) {
//                System.out.print("  ");
//            }
//
//            // Print asterisks
//            for (int k = 1; k <= 2 * i - 1; k++) {
//                System.out.print("* ");
//            }



            for (int i = 0; i <= r; i++) {
                // Print spaces before the asterisks
                for (int j = 1; j <= i ; j++) {
                    System.out.print("  ");
                }

                // Print asterisks3
                for (int k = 0; k <i; k++) {
                    System.out.print(" *");
                }
            // Move to the next line
            System.out.print("\n");
        }
    }
}
