package knapsack;

import java.util.Arrays;

public class house_robber {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0],nums[1]);
        }

        int[] scenario1 = Arrays.copyOfRange(nums,0,n-1);
        int[] scenario2 = Arrays.copyOfRange(nums,1,n);
        return Math.max(roblinear(scenario1),roblinear(scenario2));
    }
    public int roblinear(int[] nums) {
        int n = nums.length;
        int[] t = new int[nums.length];

        t[0] = nums[0];

        for(int i = 1; i < n;i++){
            int rob = nums[i];
            if(i > 1){
                rob = nums[i] + t[i-2];
            }
            int notrob = nums[i-1];
            t[i] = Math.max(rob,notrob);
        }
        return t[n-1];
    }
}
