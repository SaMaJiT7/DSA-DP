package stackandQueue;

import java.util.Stack;

public class maximum_histogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int[] width = new int[n];
        int[] left = NSL1(heights);
        int[] right = NSR(heights);
        for(int i = 0; i < n; i++){
            width[i] = right[i]-left[i]-1;
        }
        for(int i = 0; i < n; i++){
            int area = width[i]*heights[i];
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }

    public int[] NSL1(int[] nums) {
        int n = nums.length;
        int pseudoindex = -1;
        Stack<Pair> st = new Stack<>();
        int[] left = new int[n];
        for(int i = 0; i < n; i++){
            if(!st.isEmpty() && st.peek().first >= nums[i]){
                while (!st.isEmpty() && st.peek().first >= nums[i]){
                    st.pop();
                }
            }

            if(st.isEmpty()){
                left[i] = pseudoindex;
            }
            else{
                left[i] = st.peek().second;
            }
            st.push(new Pair(nums[i],i));
        }
        return left;
    }

    public int[] NSR(int[] nums) {
        int n = nums.length;
        Stack<Pair> st = new Stack<>();
        int pseudoindex = n;
        int[] right = new int[n];
        for(int i = n-1; i >= 0; i--){
            if(!st.isEmpty() && st.peek().first >= nums[i]){
                while (!st.isEmpty() && st.peek().first >= nums[i]){
                    st.pop();
                }
            }

            // Assign: top if smaller, else -1
            right[i] = st.isEmpty() ? pseudoindex : st.peek().second;

            st.push(new Pair(nums[i],i));
        }
        return right;
    }

    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
