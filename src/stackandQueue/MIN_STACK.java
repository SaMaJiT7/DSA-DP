package stackandQueue;

import java.util.ArrayList;

public class MIN_STACK {
    private ArrayList<Integer> stack;
    private ArrayList<Integer> Minstack;
    public void MinStack() {
        stack = new ArrayList<>();
        Minstack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);

        if (Minstack.isEmpty() || val <= Minstack.get(Minstack.size() - 1)) {
            Minstack.add(val);
        } else {
            Minstack.add(Minstack.get(Minstack.size() - 1));
        }
    }

    public void pop() {
        if(!stack.isEmpty()) {
            stack.remove(stack.size() - 1);
            Minstack.remove(Minstack.size()-1);
        }
    }

    public int top() {
        if(!stack.isEmpty()) {
            return stack.get(stack.size() - 1);
        }
        return 0;
    }

    public int getMin() {
        if(!stack.isEmpty() && !Minstack.isEmpty()){
            return Minstack.get(Minstack.size()-1);
        }
        if (Minstack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return 0;
    }
}
