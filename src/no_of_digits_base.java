public class no_of_digits_base {
    public static void main(String[] args) {
        int n = 4;
//        int n = 6;
//        int base = 2;
//
//        int ans = (int) (Math.log(n) / Math.log(base)) + 1;
//
//        System.out.println(ans);
//        int n = 5;
//
//        int sum = 0;
//            sum = (int) (sum + Math.pow(2,n-1));
//            n = 1 <<(n-1);
//
//        System.out.println(sum);

//        if((N & (N - 1)) == 0){
//            System.out.println("It is a Power of 2");
//        }
//        else {
//            System.out.println("It is not a Power of 2");
//        }


        int ans = 1;
        int base = 2;

        while(n > 0) {
            if((n & 1) == 1) {
                ans = ans * base;
            }
            base *= base;
            n = n >> 1;
            System.out.println(ans);
        }
    }
}
