package stackandQueue;

import java.util.Stack;

public class validate_stack {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int n = pushed.length;
        int m = popped.length;
        int i = 0;
        int j = 0;

        while(i < n){
            st.push(pushed[i]);
            while(!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
                j++;
            }
            i++;
        }
        return st.isEmpty();
    }

}
