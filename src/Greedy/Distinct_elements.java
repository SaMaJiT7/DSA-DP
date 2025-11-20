package Greedy;

import java.util.Arrays;

public class Distinct_elements {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int prev = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int max = nums[i] + k;
            int min = nums[i] - k;

            if(prev < min){
                prev = min;
                ans++;
            }
            else if(prev < max){
                prev = prev+1;
                ans++;
            }
        }
        return ans;
    }
}
