package Hashmap;

import java.util.HashMap;
import java.util.Collection;

public class special_array {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for(int i = 1; i<= n ; i++){
            if((nums[i-1]&1) != (nums[i]&1)){
                return true;
            }
        }
        return false;
    }

    public boolean checkPrimeFrequency(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for (int v : map.values()) {
            if (isPrime(v)) {
                return true;
            }
        }
        return false;
    }


    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if ((n & 1) == 0 || n % 3 == 0) return false;


        for (int i = 5; i <= n / i; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
