package HEAP;

import java.util.PriorityQueue;

public class Connect_ropes {
    public int connectRopes(int[] arr){
        int cost = 0;
        PriorityQueue<Integer> Minheap = new PriorityQueue<>();
        for(int x : arr){
            Minheap.add(x);
        }

        while (Minheap.size() >= 2){
            int first = Minheap.peek();
            Minheap.poll();
            int second = Minheap.peek();
            Minheap.poll();

            int val = first + second;
            cost += (val);

            Minheap.add(val);
        }
        return cost;
    }
}
