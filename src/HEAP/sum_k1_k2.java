package HEAP;

import java.util.Collections;
import java.util.PriorityQueue;

public class sum_k1_k2 {
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2) {
        PriorityQueue<Long> Minheap = new PriorityQueue<Long>(Collections.reverseOrder());
        for(long val : A){
            Minheap.add(val);

            if(Minheap.size() > K2){
                Minheap.poll();
            }
        }
        long ans = 0;
        Minheap.poll();
        while(Minheap.size() > K1){
            ans += Minheap.peek();
            Minheap.poll();
        }
        return ans;
    }
}
