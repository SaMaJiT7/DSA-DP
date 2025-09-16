package Sliding_Window;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class maximum_sub_k {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length == 1 || k == 1){
            return nums;
        }

        if(k > nums.length){
            Arrays.sort(nums);
            return new int[]{nums[nums.length - 1]};
        }

        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> imp = new ArrayDeque<>();

        while(j < nums.length){

            while (!imp.isEmpty() && imp.peekLast() < nums[j]) {
                imp.pollLast();
            }
            imp.offerLast(nums[j]);

            if(j-i+1 < k){
                j++;
            }
            else if (j-i+1 == k) {

                ans.add(imp.peekFirst());


                if(imp.peekFirst() == nums[i]){
                    imp.pollFirst();
                }
                i++;
                j++;
            }
        }


        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

}
