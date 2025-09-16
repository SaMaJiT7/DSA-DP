package Subsequence_DP;

import java.util.Arrays;

public class increasing_subsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] t = new int[nums.length];

        Arrays.fill(t, 1);

        for(int i = 1; i < t.length; i++){
            for(int j = 0 ; j < i; i++){
                if(nums[i] > nums[j]){
                    t[i] = Math.max(t[i],t[j]+1);
                }
            }
        }
        int maxLength = 0;
        for (int len : t) {
            maxLength = Math.max(maxLength, len);
        }
        return maxLength;
    }
}
