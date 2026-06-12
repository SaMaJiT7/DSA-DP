package Leetcode_daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class maxfixed_points {
    public int maxFixedPoints(int[] nums) {
        int n = nums.length;
        List<int[]> v = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(nums[i] <= i){
                v.add(new int[]{i-nums[i],nums[i]});
            }
        }

        v.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        List<Integer> lis = new ArrayList<>();
        for(int[] val : v){
            int q = val[0];

            int idx = Collections.binarySearch(lis,q);
            if(idx < 0) idx = -(idx+1);

            if(idx == lis.size()){
                lis.add(q);
            }
            else{
                lis.set(idx,q);
            }
        }
        return lis.size();
    }
}
