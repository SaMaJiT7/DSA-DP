package BackTracking;

import java.util.*;

public class next_greater_ele {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i = nums2.length-1; i>=0 ; i--){
            if(!st.isEmpty() && st.peek() <= nums2[i]){
                while(!st.isEmpty() && st.peek() <=nums2[i]){
                    st.pop();
                }
            }
            if(st.isEmpty()){
                map.put(nums2[i],-1);
            }
            else if (st.peek() > nums2[i]){
                map.put(nums2[i],st.peek());
            }
            st.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++){
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}
