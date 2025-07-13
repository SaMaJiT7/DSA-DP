package ALGo_In_Array;

import java.util.Scanner;

public class insering {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number you want to insert: ");
        int num = scan.nextInt();
        System.out.print("Enter the index you want to insert: ");
        int index = scan.nextInt();
        insert(num,index);
    }
    public static void insert(int n , int ix){
        Scanner scan1 = new Scanner(System.in);
        int[] arr = new int[7];
        System.out.print("Enter the Value of the Arrays: ");
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = scan1.nextInt();
        }
        for(int j = arr.length-1 ; j > ix ; j--){
            arr[j] = arr[j-1];
        }
        arr[ix] = n;
        for (int g : arr){
            System.out.println(g);
        }
    }
}
