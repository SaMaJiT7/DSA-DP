package stackandQueue;

import java.util.Stack;

public class valid_substring_longest {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        Stack<Integer> intstack = new Stack<>();
        Stack<Character> st = new Stack<>();
        intstack.push(-1);
        for(int i = 0; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(ch);
                intstack.push(i);
            }
            else{
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                    intstack.pop();
                    ans = Math.max(ans,i-intstack.peek());
                }
                else{
                    intstack.push(i);
                }
            }
        }
        return ans;
    }
}
