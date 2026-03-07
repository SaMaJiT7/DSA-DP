package Bit_manipulation;

public class alernative_bits {
    public boolean hasAlternatingBits(int n) {
        int prev = -1;
        while(n != 0){
            int bit = n & 1;
            if(bit == prev){
                return false;
            }
            n = n >> 1;
            prev = bit;
        }
        return true;
    }
    public boolean hasAlternatingBits2(int n) {
        int[] bits = new int[32];
        int i = 0;
        while(n != 0){
            bits[i++] = n & 1;
            n = n >> 1;
        }
        for(int j = 1; j <= i; j++){
            if(bits[j] == bits[j-1]){
                return false;
            }
        }
        return true;
    }
}
