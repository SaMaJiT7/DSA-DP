package ALGo_In_Array;

public class Recursion_1 {
    public static void main(String[] args) {
        System.out.println(numadd(10));
        System.out.println(factorial(5));
    }
//    public static int printnum(int n){
//        if(n == 0){
//            return 0;
//        }
//        System.out.print(n+ " ");
//        return printnum(n-1);
//    }

//    public static void numadd(int n){
//        if(n == 0){
//            return;
//        }
//        numadd(n-1);
//        System.out.print(n+ " ");
//    }
    public static int numadd(int n){
        if(n == 0){
            return 0;
        }
        return n + numadd(n-1);
    }

    public static int factorial(int n){
        if(n <= 1){
            return 1;
        }
        return n * factorial(n-1);
    }
}
