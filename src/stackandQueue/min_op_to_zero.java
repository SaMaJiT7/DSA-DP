package stackandQueue;

import java.util.Stack;

public class min_op_to_zero {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int ops = 0;
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[i] < st.peek()){
                    st.pop();
            }

            if(nums[i] == 0) continue;


            if(st.isEmpty() || st.peek() < nums[i]){
                st.push(nums[i]);
                ops += 1;
            }
        }
        return ops;
    }
}
