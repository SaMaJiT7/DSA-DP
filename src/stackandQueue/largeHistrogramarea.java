package stackandQueue;

import java.util.Stack;

public class largeHistrogramarea {
    public static void main(String[] args) {

    }


    public int largestRectangleArea(int[] heights) {
        Stack<Integer> storestack = new Stack<>();
        int max = 0;
        storestack.push(0);

        for (int i = 1; i < heights.length ; i++) {
            while(!storestack.isEmpty() && heights[i] < heights[storestack.peek()]){
                max = getMax(storestack,heights,max,i);
            }
            storestack.push(i);
        }

        int i = heights.length;
        while (!storestack.isEmpty()){
            max = getMax(storestack,heights,max,i);
        }
        return max;
    }

    private int getMax(Stack<Integer> stack,int[] arr,int max,int i){
        int area;

        int popped = stack.pop();
        if(stack.isEmpty()){
            area = arr[popped] * i;
        }
        else {
            area = arr[popped] * (i-1-stack.peek());
        }
        return Math.max(max,area);
    }
}
