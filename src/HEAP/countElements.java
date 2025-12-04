package HEAP;

import java.util.PriorityQueue;

public class countElements {
    public int countElements(int[] nums, int k) {
        if(k == 0){
            return nums.length;
        }
        if(k > nums.length){
            return 0;
        }
        PriorityQueue<Integer> MinHeap = new PriorityQueue<>();

        for(int num : nums){
            MinHeap.offer(num);
            if(MinHeap.size() > k){
                MinHeap.poll();
            }
        }

        int limit = MinHeap.peek();

        int count = 0;
        for(int num : nums){
            if(num < limit){
                count++;
            }
        }
        return count;
    }
}
