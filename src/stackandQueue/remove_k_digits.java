package stackandQueue;

import java.util.Stack;

public class remove_k_digits {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k >= n) return "0";

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i++){
            char val = num.charAt(i);
            while(k > 0 && !st.isEmpty() && st.peek() > val){
                st.pop();
                k--;
            }
            st.add(val);
        }

        while(k > 0){
            st.pop();
            k--;
        }

        StringBuilder s = new StringBuilder();
        while(!st.isEmpty()){
            s.append(st.pop());
        }
        s.reverse();
        int zeroidx = 0;
        while(zeroidx < s.length() && s.charAt(zeroidx) == '0') {
            zeroidx++;
        }

        if(zeroidx == s.length()) return "0";

        return s.substring(zeroidx);
    }
}
