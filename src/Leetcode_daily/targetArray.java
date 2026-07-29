package Leetcode_daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class targetArray {
//    public int[] createTargetArray(int[] nums, int[] index) {
//        List<Integer> arr = new ArrayList<>();
//        int n = nums.length;
//        for(int i = 0; i < n; i++){
//            int val = nums[i];
//            int idx = index[i];
//            arr.add(idx,val);
//        }
//        return arr.stream().mapToInt(i->i).toArray();
//    }
public int[] createTargetArray(int[] nums, int[] index) {
    int n = nums.length;
    int[] target = new int[n];
    Arrays.fill(target,-1);
    for(int i = 0; i < n; i++){
        int val = nums[i];
        int idx = index[i];
        if(target[idx] != -1){
            int j = idx+1;
            while(target[j] != -1){
                j++;
            }
            while(j >= idx + 1){
                target[j] = target[j-1];
                j--;
            }
        }
        target[idx] = val;
    }
    return target;
}
}
