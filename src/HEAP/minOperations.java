package HEAP;

import java.util.PriorityQueue;

public class minOperations {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        PriorityQueue<Long> Minheap = new PriorityQueue<>();
        for(int i = 0; i < nums.length;i++) {
            Minheap.add((long) nums[i]);
        }
            while(Minheap.peek() < k && Minheap.size() >= 2){
                long x = Minheap.poll();
                long y = Minheap.poll();
                long value = (Math.min(x,y) * 2 + Math.max(x,y));
                Minheap.add(value);
                count++;
            }
        return count;
    }
}
