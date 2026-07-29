package Leetcode_daily;

import java.util.Arrays;

public class gcdSum {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] maxat = new int[n];
        maxat[0] = nums[0];
        for(int i = 1; i < n; i++){
            maxat[i] = Math.max(maxat[i-1],nums[i]);
        }
        int[] prefixGcd = new int[n];
        for(int i = 0; i < n; i++){
            prefixGcd[i] = gcd(nums[i],maxat[i]);
        }
        Arrays.sort(prefixGcd);
        int i = 0;
        int j = n-1;
        int sum = 0;
        while(i < j){
            int small = prefixGcd[i];
            int large = prefixGcd[j];
            sum += gcd(small,large);
            i++;
            j--;
        }

        return sum;
    }
    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b,a % b);
    }
}
