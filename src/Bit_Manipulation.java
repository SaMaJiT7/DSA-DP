import java.util.Scanner;

public class Bit_Manipulation {
   public static void main(String[] args) {
       int n = 5;
       int i = 4;
       magicnumb(6);
//     ith(n,i);
//       int[] arr = {2,3,4,1,2,1,3,6,4};
//       System.out.println(uniNum(arr));
//        int n = 12;
//        isOdd(n);
//    }
//
//    static void isOdd(int n) {
//        if ((n & 1) == 1){
//            System.out.printf("Odd Number it is %d",n);
//        }
//        else {
//            System.out.printf("Even Number it is %d",n);
//        }


    }

    private static void magicnumb(int n) {
      int ans = 0;
      int base = 5;

      while(n > 0){
          int last = n & 1;
          n = n >> 1;

          ans = ans + last * base;
          base = base * 5;
      }
        System.out.println(ans);
    }

//    private static void ith(int n,int i) {
//       int a = (n | 1 << i-1);
//        System.out.println(a);
//    }

//    public static int uniNum(int[] arr) {
//       int unique = 0;
//           for (int elements : arr) {
//                   unique = unique ^ elements;
//       }
//       return unique;
//    }

}
