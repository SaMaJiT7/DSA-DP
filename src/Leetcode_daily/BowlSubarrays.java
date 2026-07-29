package Leetcode_daily;

import java.util.Stack;

public class BowlSubarrays {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length;
        int[] left = getNGL(nums);
        int[] right = getNGR(nums);
        int count = 0;
        for(int i = 0; i < n; i++){
            if(left[i] == -1  || right[i] == -1){
                continue;
            }
            else{
                count++;
            }
        }
        return count;
    }
    private int[] getNGL(int[] nums){
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    private int[] getNGR(int[] nums){
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && nums[i] >= nums[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = i;
            }
            st.push(i);
        }
        return ans;
    }
}
