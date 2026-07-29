package Leetcode_daily;

import java.util.PriorityQueue;

public class kth_largest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            pq.add(nums[i]);

            while(pq.size() > k){
                pq.poll();
            }
        }
        return !pq.isEmpty() ? pq.peek() : -1;
    }
}

