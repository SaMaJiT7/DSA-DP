package stackandQueue;

import java.util.Stack;

public class decodeString {
    public String decodeString(String s) {
        int n = s.length();
        Stack<String> st = new Stack<>();
        StringBuilder digit = new StringBuilder();
        StringBuilder currentstr = new StringBuilder();
        for(int i = 0; i < n; i++){
            char curr = s.charAt(i);
            if(Character.isDigit(curr)){
                digit.append(curr);
            }
            else if(curr == '['){
                st.push(currentstr.toString());
                st.push(digit.toString());
                currentstr = new StringBuilder();
                digit = new StringBuilder();
            }
            else if(Character.isLetter(curr)){
                currentstr.append(curr);
            }
            else if(curr == ']'){
                int top = Integer.parseInt(st.pop());
                StringBuilder repeated = new StringBuilder();
                for(int k = 0; k < top; k++) {
                    repeated.append(currentstr);
                }
                StringBuilder prevStr = new StringBuilder(st.pop());
                prevStr.append(repeated);
                currentstr = prevStr;
            }
        }
        return currentstr.toString();
    }
}
