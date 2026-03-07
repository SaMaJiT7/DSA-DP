package Bit_manipulation;

import java.util.Arrays;

public class prime_bit {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        boolean[] prime = new boolean[32];
        Arrays.fill(prime,true);
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; i * i <= 31;i++){
            if(prime[i]){
                for(int j = i*i; j < 32; j += i){
                    prime[j] = false;
                }
            }
        }
        for(int i = left; i <= right; i++){
            int count = 0;
            int x = i;
            while(x != 0){
                count += x & 1;
                x = x >> 1;
            }
            if(prime[count]){
                ans += 1;
            }
        }
        return ans;
    }
}
