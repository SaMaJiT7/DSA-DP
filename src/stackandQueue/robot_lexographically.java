package stackandQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class robot_lexographically {
    public String robotWithString(String s) {
        int n = s.length();
        char[] minlast = new char[n+1];
        StringBuilder p = new StringBuilder();
        minlast[n] = 'z' + 1;
        Deque<Character> st = new ArrayDeque<>();

        for(int i = n-1; i >= 0; i--){
            minlast[i] = (char)Math.min(s.charAt(i),minlast[i+1]);
        }
        for(int i = 0; i < n; i++){
            st.push(s.charAt(i));
            while(!st.isEmpty() &&  st.peek() <= minlast[i+1]){
                char t = st.pop();
                p.append(t);
            }
        }
        while (!st.isEmpty()) {
            p.append(st.pop());
        }
        return p.toString();
    }
}
