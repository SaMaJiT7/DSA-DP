package Leetcode_daily;

import java.util.Arrays;

public class alternative_prime {
    static int N = (int) ((int) 2e6);
    boolean[] isprime;
    public int minOperations(int[] nums) {
        isprime = new boolean[N];
        Arrays.fill(isprime,true);
        isprime[0] = false;
        isprime[1] = false;
        for(int i = 2; i * i < N; i++){
            if(isprime[i]){
                for(int j = i * i; j < N; j += i){
                    isprime[j] = false;
                }
            }
        }
        int operations = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                int x = nums[i];
                if(isprime[x]) continue;
                else{
                    while(!isprime[x]){
                        x++;
                    }
                    operations += (x-nums[i]);
                }
            }
            else{
                int x = nums[i];
                if(!isprime[x]){
                    continue;
                }
                else{
                    while(isprime[x]){
                        x++;
                    }
                    operations += (x-nums[i]);
                }
            }
        }
        return operations;
    }
}
