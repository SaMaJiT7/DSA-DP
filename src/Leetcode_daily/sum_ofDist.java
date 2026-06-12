package Leetcode_daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class sum_ofDist {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        HashMap<Integer, List<Integer>> idx = new HashMap<>();
        for(int i = 0; i < n; i++){
            idx.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i);
        }
        for(List<Integer> indices : idx.values()){
            long[] prefix = new long[indices.size()];
            prefix[0] = indices.get(0);
            for(int i = 1; i < indices.size(); i++){
                prefix[i] = prefix[i-1] + indices.get(i);
            }
            for(int i = 0; i < indices.size(); i++){
                int index = indices.get(i);
                long leftsum = (i != 0 ? prefix[i-1] : 0);
                int leftcount = i;
                long rightsum = prefix[indices.size()-1] - prefix[i];
                int rightcount = indices.size() - i - 1;

                long sum = ( (long)leftcount * index - leftsum )
                        + ( rightsum - (long)rightcount * index );
                ans[index] = sum;
            }
        }
        return ans;
    }
}
