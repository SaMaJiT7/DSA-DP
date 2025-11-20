package stackandQueue;

import java.util.Stack;

public class STACK_MIN_1 {
    private Stack<Long> stack;
    private int minEle;

    public void MinStack() {
        stack = new Stack<>();
        minEle = Integer.MAX_VALUE;  // Initial sentinel
    }

    public void push(int val) {
        long longVal = val;  // Cast to long for safe calculations
        if (stack.isEmpty()) {
            stack.push(longVal);
            minEle = val;
        } else if (val >= minEle) {
            stack.push(longVal);
        } else {
            // Safe encoding using long
            long encoded = 2L * longVal - minEle;
            stack.push(encoded);
            minEle = val;
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;  // Or throw exception as needed
        }
        long top = stack.pop();
        if (top < minEle) {
            // Safe decoding
            minEle = (int) (2L * minEle - top);
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        long top = stack.peek();
        if (top < minEle) {
            return minEle;  // Decoded actual top
        }
        return (int) top;
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return -1;
        }
        return minEle;
    }
}
