package Bit_manipulation;

public class MinFlips {
    public int minFlips(int a, int b, int c) {
//        if((a | b) == c) return 0;
//
//        int min = 0;
//        while(a > 0 || b > 0 || c > 0){
//            int a_bit = a&1;
//            int b_bit = b&1;
//            int c_bit = c&1;
//            if((a_bit | b_bit) != c_bit){
//                if(c_bit == 1){
//                    min += 1;
//                }
//                else{
//                    min += (a_bit + b_bit);
//                }
//            }
//            a = a >> 1;
//            b = b >> 1;
//            c = c >> 1;
//        }
//        return min;
        int temp = ((a|b) ^ c); // this gives us how many bits differ between a|b and c.
        int missed = ((a&b) & temp); // this gives how many flips we have missed for 1 | 1

        return countSetBits(temp) + countSetBits(missed);
    }
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
