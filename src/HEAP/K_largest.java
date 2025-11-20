package HEAP;

import java.util.PriorityQueue;

public class K_largest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> Minheap = new PriorityQueue<>();

        for(int num : nums){
            Minheap.add(num);

            if(Minheap.size() > k){
                Minheap.poll();
            }
        }
        return Minheap.peek();
    }
}
