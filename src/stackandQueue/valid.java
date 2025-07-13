package stackandQueue;

import java.util.Stack;

public class valid {
//    public int minInsertions(String s) {
//        Stack<Character> stack = new Stack<>();
//
//        for(char ch : s.toCharArray()){
//            if(ch == '('){
//                if(!stack.isEmpty() && stack.peek() == ')'){
//                    stack.pop();
//                }else {
//                    stack.push(ch);
//                }
//            }else{
//                stack.push(ch);
//            }
//        }
//        return stack.size();
//    }

    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int insertions = 0;
        int rightneed = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
                rightneed = rightneed + 2;
            }
            if(ch == ')'){
                if(stack.peek() == '('){
                    stack.pop();
                }
            }
            if (rightneed % 2 != 0) {
                insertions++;
                rightneed--;
            }
            else{
                rightneed-- ;
            }

            if (rightneed < 0) {
                insertions++;
                rightneed = 1;
            }
        }
        return insertions + rightneed;
    }
}
