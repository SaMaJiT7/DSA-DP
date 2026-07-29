package Leetcode_daily;

import java.util.Arrays;

public class decrease_rearrange {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        if(arr[0] != 1){
            arr[0] = 1;
        }
        int maxElement = arr[0];
        for(int i = 1; i < n; i++){
            if(Math.abs(arr[i] - arr[i-1]) <= 1){
                maxElement = Math.max(maxElement,arr[i]);
            }
            else{
                arr[i] = arr[i-1] + 1;
                maxElement = Math.max(maxElement,arr[i]);
            }
        }
        return maxElement;
    }
}
