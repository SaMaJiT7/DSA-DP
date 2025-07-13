package ALGo_In_Array;

public class asiicisubset {
    public static void main(String[] args) {
        String str = "";
        String str1 = "ab";
        //SubAsi(str,str1);
        System.out.println(myPow(2.100,3));
    }
//    static void SubAsi(String p , String up){   /// p represent processed string and up represent unprocessed string
//        if(up.isEmpty()){
//            if(p.isEmpty()){
//                return;
//            }
//            System.out.printf("["+p+"]");;
//            return;
//        }
//
//        char ch = up.charAt(0);
//
//        SubAsi(p + ch ,up.substring(1));
//        SubAsi(p,up.substring(1));
//        SubAsi(p + (ch+0),up.substring(1));
//    }
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double result = 1;

        // If n is negative, convert x to its reciprocal and negate n
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        while (n > 0) {
            // If n is odd, multiply result by x
            if (n % 2 == 1) {
                result *= x;
            }

            // Divide n by 2 and square x
            x *= x;
            n /= 2;
        }

        return result;
    }
}
