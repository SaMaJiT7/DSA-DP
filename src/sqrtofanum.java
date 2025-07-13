import java.util.Scanner;

public class sqrtofanum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number whose sqrt you want to know: ");
        int n = sc.nextInt();
        int p = 3;
        System.out.printf("%.3f",binarysqrt(n,p));
    }
//    public static double square(double n){
//        for (double i = 1; i <=n/2; i++) {
//            if(i * i == n){
//                return i;
//            }
//        }
//        return -1;
//    }

    public static double binarysqrt(int n,int p){
        int s = 0;
        int e = n;

        double root = 0.0;

        while (s < e){
            int mid = s + (e-s)/2;

            if(mid * mid > n){
                e = mid - 1;
            }
            else if (mid * mid < n){
                s = mid + 1;
            }
            else {
               return mid;
            }
        }
        double incre = 0.1;
        for (int i = 0; i < p ; i++){
            while (root * root <= n){
                root+=incre;
            }
            root-=incre;
            incre = incre/10;
        }
        return root;
    }
}
