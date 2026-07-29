package HEAP;

import java.util.PriorityQueue;

public class find_median {
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    public find_median() {
        this.maxheap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        this.minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxheap.add(num);

        if(!minheap.isEmpty() && !maxheap.isEmpty() && maxheap.peek() > minheap.peek()){
            minheap.add(maxheap.poll());
        }
        if(maxheap.size() > minheap.size()+1){
            minheap.add(maxheap.poll());
        } else if (minheap.size() > maxheap.size()) {
            maxheap.add(minheap.poll());
        }
    }

    public double findMedian() {
        if(maxheap.isEmpty() || minheap.isEmpty()) return 0.0;
        if(maxheap.size() > minheap.size()){
            return maxheap.peek();
        }
        return (maxheap.peek() + minheap.peek()) / 2.0;
    }
}
