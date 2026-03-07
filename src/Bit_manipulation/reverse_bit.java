package Bit_manipulation;

import java.util.Arrays;

public class reverse_bit {
//    public int reverseBits(int n) {
//        int ans = 0;
//        int[] bits = new int[32];
//        Arrays.fill(bits,0);
//        for(int i = 31; i >= 0; i--){
//            bits[i] = n & 1;
//            n = n >> 1;
//        }
//        for(int i = 0; i < 32; i++){
//            ans += bits[i] * (1 << i);
//        }
//        return ans;
//    }
    public int reverseBits(int n) {
        if(n == 0){
            return 0;
        }
        int result = 0;
        for(int i = 0; i <= 31; i++){
            result = result << 1;
            result = (result | (n & 1));
            n = n >> 1;
        }
        return result;
    }
}
