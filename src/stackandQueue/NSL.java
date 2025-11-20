package stackandQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NSL {
    public int[] nextSmallerElements(int[] nums) {
       int n = nums.length;
       Stack<Integer> st = new Stack<>();
       int[] ans = new int[n];
       for(int i = 0; i < n; i++){
           if(!st.isEmpty() && st.peek() > nums[i]){
               while (!st.isEmpty() && st.peek() > nums[i]){
                   st.pop();
               }
           }

           if(st.isEmpty()){
               ans[i] = -1;
           }
           else if(st.peek() < nums[i]){
               ans[i] = st.peek();
           }
           st.push(nums[i]);
       }
       return ans;
    }

    public int[] nextSmallerElementsRight(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i = n-1; i >= 0; i--){
            if(!st.isEmpty() && st.peek() > nums[i]){
                while (!st.isEmpty() && st.peek() > nums[i]){
                    st.pop();
                }
            }

            // Assign: top if smaller, else -1
            ans[i] = st.isEmpty() ? -1 : st.peek();

            st.push(nums[i]);
        }
        return ans;
    }
}
