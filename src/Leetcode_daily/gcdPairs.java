package Leetcode_daily;

import java.util.ArrayList;
import java.util.List;

public class gcdPairs {
    int max;
    public int[] gcdValues(int[] nums, long[] queries) {
        int n = nums.length;
        this.max = Integer.MIN_VALUE;
        long[] freq = new long[n];
        for(int val : nums){
            max = Math.max(max,val);
            freq[val]++;
        }
        long[] ans = new long[max+1];
        for(int g = max; g > 0; g--){
            long totalmultiples = 0;

            for(int multiple = g; multiple <= max; multiple += g){
                totalmultiples += freq[multiple];
            }

            long totalpairs = (totalmultiples * (totalmultiples - 1))/ 2;

            for(int multiple = 2*g; multiple <= max; multiple += g){
                totalpairs -= ans[multiple];
            }
            ans[g] = totalpairs;
        }
        long[] prefix = new long[max+1];
        prefix[1] = ans[1];
        for(int i = 2; i <= max; i++){
            prefix[i] = prefix[i-1] + ans[i];
        }

        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            long target = queries[i] + 1;
            result[i] = custom_BS(target,prefix);
        }
        return result;
    }
    public int custom_BS(long target, long[] prefix){
        int low = 1;
        int high = max;

        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(prefix[mid] >= target){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
