package stackandQueue;

import java.util.Stack;

public class ERPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String ch : tokens){
            if(ch.equals("+")){
                int v1 = st.pop();
                int v2 = st.pop();
                st.push((v1 + v2));
            }
            else if(ch.equals("-")){
                int v1 = st.pop();
                int v2 = st.pop();
                st.push((v2 - v1));
            }
            else if(ch.equals("*")){
                int v1 = st.pop();
                int v2 = st.pop();
                st.push((v1 * v2));
            }
            else if(ch.equals("/")){
                int v1 = st.pop();
                int v2 = st.pop();
                st.push((v2/v1));
            }
            else{
                st.push(Integer.parseInt(ch));
            }
        }
        return st.peek();
    }
}
