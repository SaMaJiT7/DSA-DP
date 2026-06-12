package Leetcode_daily;

import java.util.Arrays;

public class sumofPrimes {
    static int range = 1024;
    static boolean[] isprime = new boolean[range+1];
    static int[] prefix = new int[range + 1];
    static{
        Arrays.fill(isprime,true);
        isprime[0] = false;
        isprime[1] = false;

        for(int i = 4; i <= range; i+=2){
            isprime[i] = false;
        }

        for(int i = 3; i*i <= range; i+=2){
            if(isprime[i]){
                for(int j = i*i; j <= range; j += (i << 1)){
                    isprime[j] = false;
                }
            }
        }

        for(int i = 2; i <= range; i++){
            prefix[i] = prefix[i-1] + (isprime[i] ? i : 0);
        }
    }
    public int sumOfPrimesInRange(int n) {
        int r = getReverse(n);
        int low = Math.min(n,r);
        int high = Math.max(n,r);

        return prefix[high] - (low == 0 ? 0 : prefix[low-1]);
    }
    public int getReverse(int n){
        int num = 0;
        int x = n;
        while(x != 0){
            int rem = x % 10;
            num = num * 10 + rem;
            x = x / 10;
        }
        return num;
    }
}
