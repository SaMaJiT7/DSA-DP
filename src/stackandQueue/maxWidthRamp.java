package stackandQueue;

import java.util.Arrays;
import java.util.Stack;

public class maxWidthRamp {
    public int maxWidthRamp(int[] nums) {
        //This is the brute-force approach it will work upto 10^4 input space, otherwise will provide a TLE.
//        int n = nums.length;
//        int maxlength = 0;
//        for (int i = 0; i < n; i++) {
//            int farthest = -1;
//            for (int j = n - 1; j > i; j--) { // scan from right to left
//                if (nums[j] > nums[i]) {
//                    farthest = j;
//                    break; // first greater from the rightmost side
//                }
//            }
//            maxlength = Math.max(maxlength,farthest-i);
//        }
//        return maxlength;

        Stack<Integer> st = new Stack<>();
        int Maxramp = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(st.isEmpty() || nums[i] < nums[st.peek()]){
                st.push(i);
            }
        }

        for(int j = n-1; j >= 0; j--){
            while(!st.isEmpty() && nums[j] >= nums[st.peek()]){
                Maxramp = Math.max(Maxramp,j - st.peek());
                st.pop();
            }
        }
        return Maxramp;
    }
}
