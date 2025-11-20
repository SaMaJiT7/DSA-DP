package stackandQueue;

import java.util.Stack;

public class greater_next_ele {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        for(int i = n-1; i >= 0 ; i--){
            st.push(nums[i]);
        }
        int[] nge = new int[n];
        for (int i = n-1; i >= 0; i--){
            if(!st.isEmpty() && st.peek() <= nums[i]){
                while(!st.isEmpty() && st.peek() <= nums[i]){
                    st.pop();
                }
            }
            if(st.isEmpty()){
                nge[i] = -1;
            }
            else if (st.peek() > nums[i]){
               nge[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return nge;
    }

    public int[] nextGreaterElementsLeft(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[i] >= st.peek()){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = -1;
            }
            else if(st.peek() > nums[i]){
                ans[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return ans;
    }
}
