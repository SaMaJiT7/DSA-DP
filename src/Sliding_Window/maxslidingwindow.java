package Sliding_Window;

import java.util.*;

public class maxslidingwindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        int j = 0;
        while(j < n){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[j]){
                dq.pollLast();
            }
            dq.add(j);


            if(j-i+1 == k){
                answer.add(nums[dq.peekFirst()]);

                if(!dq.isEmpty() && dq.peekFirst() == i){
                    dq.pollFirst();
                }
                i++;
            }
            j++;
        }
        return answer.stream().mapToInt(a -> a).toArray();
    }
}
