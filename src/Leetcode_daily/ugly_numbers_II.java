package Leetcode_daily;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class ugly_numbers_II {
    public int nthUglyNumber(int n) {
        if(n == 1){
            return 1;
        }
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add((long) 1);
        int nth = 0;
        HashSet<Long> unique = new HashSet<>();
        int answer = 0;
        while(nth < 10){
            long curr = queue.poll();
            answer = (int) curr;
            unique.add(curr);
            nth++;
            if(!queue.contains(curr*2))queue.add(curr*2);
            if(!queue.contains(curr*3))queue.add(curr*3);
            if(!queue.contains(curr*5))queue.add(curr*5);
        }
        return answer;
    }
}
