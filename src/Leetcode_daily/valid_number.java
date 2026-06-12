package Leetcode_daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class valid_number {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        int max = 0;
        for(int i = 0; i < n; i++){
            prefix[i] = max;
            max = Math.max(max,nums[i]);
        }
        max = 0;
        for(int i = n-1; i >= 0; i--){
            suffix[i] = max;
            max = Math.max(max,nums[i]);
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > prefix[i] || nums[i] > suffix[i]){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}
