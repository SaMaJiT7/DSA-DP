package Leetcode_daily;

public class minElement {
    public int minElement(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int val = nums[i];
            int newVal = 0;
            while(val > 0){
                newVal += (val % 10);
                val = val / 10;
            }
            min = Math.min(min,newVal);
        }
        return min;
    }
}
