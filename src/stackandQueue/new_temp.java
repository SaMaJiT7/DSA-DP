package stackandQueue;

import java.util.Stack;

public class new_temp {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        // Iterate from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop while stack not empty and top temp <= current
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            // If stack not empty, calculate days to next warmer
            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }  // Else remains 0
            // Push current index
            stack.push(i);
        }
        return result;
    }
}
