package stackandQueue;

import java.util.Stack;

public class minimum_insertions {
    public int minInsertions(String s) {
        int insertions = 0;
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(ch);
            }
            else{
                boolean haspair = false;
                if(i+1 < s.length()) {
                    char nexch = s.charAt(i + 1);
                    if(nexch == ')') {
                        haspair = true;
                        i++;
                    }
                }
                if(!haspair){
                    insertions++;
                }

                if(!st.isEmpty()){
                    st.pop();
                }
                else{
                    insertions++;
                }
            }

        }

        insertions += st.size() * 2;
        return insertions;
    }
}
