public class setbits {
    public static void main(String[] args) {
        int a = 9;

//        System.out.println(Integer.toBinaryString(n));
//
//        System.out.println(setbit(n));


//    private static int setbit(int n) {
//        int count = 0;
//
//        while(n > 0){
//            count++;
//    //        n = n - (n & (-n));
//            n = n & (n-1);
//        }
//        return count;

            if(a % 4 == 0){
                System.out.println(a);

            }
            else if (a % 4 == 1) {
                System.out.println(1);

            }
            else if (a % 4 == 2){
                System.out.println(a+1);
            }
            else if (a % 4 == 3){
                System.out.println(0);
        }
    }
}
