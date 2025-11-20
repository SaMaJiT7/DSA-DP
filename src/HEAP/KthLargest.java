package HEAP;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> Minheap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        Minheap = new PriorityQueue<>();


        for(int i = 0; i < nums.length; i++){
            Minheap.add(nums[i]);
            if(Minheap.size() > k){
                Minheap.poll();
            }
        }
    }

    public int add(int val) {
        if(Minheap.size() < k){
            Minheap.add(val);
        }
        else if(val > Minheap.peek()){
            Minheap.poll();
            Minheap.add(val);
        }
        return Minheap.peek();
    }
}
