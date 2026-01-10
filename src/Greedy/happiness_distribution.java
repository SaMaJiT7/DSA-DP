package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class happiness_distribution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        long sum = 0;
        int globalCount = 0;
        PriorityQueue<Integer> MaxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int val : happiness){
            MaxHeap.offer(val);
        }
        while(k-- > 0 && !MaxHeap.isEmpty()){
            int top = MaxHeap.poll();

            int effective = Math.max(0,top - globalCount);
            sum += effective;

            if (effective == 0) break;           // everything left is zero

            globalCount++;
        }
        return sum;
    }
    public long maximumHappinessSum0(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long sum = 0;
        for(int i = 0; i < k; i++){
            int effective = happiness[n-i-1] - i;
            if(effective > 0) {
                sum += effective;
            }
        }
        return sum;
    }
}
