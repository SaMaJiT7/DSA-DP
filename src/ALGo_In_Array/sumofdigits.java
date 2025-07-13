package ALGo_In_Array;

public class sumofdigits {
    public static void main(String[] args) {
       // System.out.println(sumdigits(1));
        fun(5);
    }
//    public static int sumdigits(int n){
//        if(n == 0){
//            return 0;
//        }
//        return (n % 10) + sumdigits(n / 10);
//    }
    public static void fun (int n){
        if(n== 0){
            return;
        }
        System.out.println(n);
        fun(--n);
    }
}
