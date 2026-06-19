package stackandQueue;

import java.net.Inet4Address;
import java.util.Stack;

public class large_histogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] NSL = NSL(heights);
        int[] NSR = NSR(heights);
        int[] width = new int[n];
        for(int i = 0; i < n; i++){
            width[i] = NSR[i] - NSL[i] - 1;
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max,(heights[i]*width[i]));
        }

        return max;
    }
    public int[] NSL(int[] heights){
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] nsl = new int[n];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsl[i] = -1;
            }
            else{
                nsl[i] = st.peek();
            }
            st.push(i);
        }
        return nsl;
    }
    public int[] NSR(int[] heights){
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] nsr = new int[n];
        for(int i = n-1; i >= 0 ; i++){
            System.out.println("i = " + i);
            if(!st.isEmpty()){
                System.out.println("peek = " + st.peek());
            }
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsr[i] = n;
            }
            else{
                nsr[i] = st.peek();
            }
            st.push(i);
        }
        return nsr;
    }
}
