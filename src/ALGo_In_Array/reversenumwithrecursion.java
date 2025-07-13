package ALGo_In_Array;

public class reversenumwithrecursion {
    public static void main(String[] args) {
      //  System.out.println(rev1(212));
      //  System.out.println(palindrome(131));
       // System.out.println(sum);
       // System.out.println(countzero(3002004,c));
        System.out.println(steps(14));
    }
    //static int sum = 0;

//    public static void rev(int n){
//        if(n == 0){
//            return;
//        }
//        int rem = n % 10;
//        sum = sum * 10 + rem ;
//        rev(n / 10);
//    }
//    public static int rev1(int n ) {
//        int digits = (int) (Math.log10(n) + 1);
//        return helper(n,digits);
//    }
//        public static int helper(int n , int base){
//        if(n % 10 == n){
//            return n;
//        }
//        return (int)((n % 10) * Math.pow(10,base-1) + helper(n / 10,base-1));
//    }
//
//
//    static boolean palindrome(int n){
//        return rev1(n) == n;
//    }

//    static int c = 0;
//    public static int countzero(int n,int c){
//        int rem = n % 10;
//        if(n == 0){
//            return c;
//        }
//        if(rem == 0){
//            return countzero(n/10,c+1);
//        }else {
//            return countzero(n / 10,c);
//        }
//    }

    static int steps(int num){
        return helper(num , 0);
    }

    static int s = 0;
    private static int helper(int num, int s) {
        if (num == 0){
            return s;
        }
        if(num % 2 == 0){
            return helper(num / 2 , s+1);
        }
        else {
            return helper(num - 1 , s+1);
        }
    }
}
