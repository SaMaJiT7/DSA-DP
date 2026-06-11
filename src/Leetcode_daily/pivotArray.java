package Leetcode_daily;

import java.util.ArrayList;
import java.util.List;

public class pivotArray {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int occur = 0;
        for(int val : nums){
            if(val == pivot){
                occur++;
            }
        }
        List<Integer> greater = new ArrayList<>();
        List<Integer> lesser = new ArrayList<>();
        for(int val : nums){
            if(val < pivot){
                lesser.add(val);
            }
            else if(val > pivot){
                greater.add(val);
            }
        }
        List<Integer> answer = new ArrayList<>();
        answer.addAll(lesser);
        for(int i = 0; i < occur; i++){
            answer.add(pivot);
        }
        answer.addAll(greater);

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
