package stackandQueue;

import java.util.Stack;

public class valid_parenthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(st.isEmpty() || ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else if (st.peek() == '(' && ch == ')') {
                st.pop();
            }
            else if(st.peek() == '{' && ch == '}'){
                st.pop();
            }
            else if(st.peek() == '[' && ch == ']'){
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
