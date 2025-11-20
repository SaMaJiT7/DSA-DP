package stackandQueue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class remove_duplicate {
    public String removeDuplicateLetters(String s) {
        boolean[] seen = new boolean[26];
        Stack<Character> st = new Stack<>();
        HashMap<Character, Integer> lastIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lastIndexMap.put(c, i);  // overwrites, so last occurrence remains
        }

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int curr = ch - 'a';
            if (seen[curr]) continue;
            while (!st.isEmpty() && st.peek() > ch && i < lastIndexMap.get(st.peek())) {
                seen[st.peek() - 'a'] = false;
                st.pop();
            }
            st.push(ch);
            seen[curr] = true;
        }
        StringBuilder ans = new StringBuilder();
        for (char c : st) ans.append(c);

        return ans.toString();
    }
}
