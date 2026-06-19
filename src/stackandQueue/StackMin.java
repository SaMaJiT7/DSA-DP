package stackandQueue;

import java.util.Stack;

public class StackMin {
    Stack<Integer> st;
    Stack<Integer> minst;
    public StackMin() {
        st = new Stack<>();
        minst = new Stack<>();
    }

    public void push(int value) {
        if(minst.isEmpty() || minst.peek() >= value){
            st.add(value);
            minst.add(value);
        }
        else{
            st.push(value);
        }
    }

    public void pop() {
        if(st.pop().equals(minst.peek())){
            minst.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minst.peek();
    }
}
