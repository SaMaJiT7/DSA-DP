package HEAP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Kth_smallest {
    public static int ksmallest(int[] nums,int k){
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(maxheap.isEmpty() || maxheap.size() < k){
                maxheap.add(nums[i]);
            } else if (maxheap.peek() > nums[i]) {
                maxheap.poll();
                maxheap.add(nums[i]);
            }
        }
        return maxheap.peek();
    }
    public static int[] klargest(int[] nums,int k){
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            minheap.add(nums[i]);
            if(minheap.size() > k){
                minheap.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (minheap.size() != 0) {
            ans.add(minheap.poll());  // Adds in ascending order (smallest of largest first)
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
