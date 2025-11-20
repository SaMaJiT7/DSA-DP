package stackandQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class remove_k_balance {
    public String removeSubstring(String s, int k) {
        // Stack of character and count
        List<Pair> st = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && st.get(st.size() - 1).ch == ch) {
                st.get(st.size() - 1).count++;
            } else {
                st.add(new Pair(ch, 1));
            }

            if (st.size() >= 2 &&
                    st.get(st.size() - 1).ch == ')' &&
                    st.get(st.size() - 2).ch == '(') {

                int openBrackets = st.get(st.size() - 2).count;
                int closeBrackets = st.get(st.size() - 1).count;

                int validPairs = Math.min(openBrackets, closeBrackets);

                if (validPairs >= k) {
                    st.get(st.size() - 2).count -= validPairs;
                    st.get(st.size() - 1).count -= validPairs;
                }

                if (st.get(st.size() - 1).count == 0) {
                    st.remove(st.size() - 1);
                }
                if (!st.isEmpty() && st.get(st.size() - 1).count == 0) {
                    st.remove(st.size() - 1);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (Pair p : st) {
            ans.append(String.valueOf(p.ch).repeat(p.count));
        }

        return ans.toString();
    }

    // Helper class to store char + count
    static class Pair {
        char ch;
        int count;
        Pair(char c, int cnt) {
            ch = c;
            count = cnt;
        }
    }
}
