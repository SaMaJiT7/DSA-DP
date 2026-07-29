package Leetcode_daily;

import java.util.Arrays;
import java.util.PriorityQueue;

public class last_stone {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int i = n-1; i >= 0; i--){
            maxheap.add(stones[i]);
        }
        if(maxheap.size() == 1) return maxheap.peek();

        while(maxheap.size() > 1){
            int y = maxheap.poll();
            int x = maxheap.poll();
            if(x != y){
                maxheap.add(y-x);
            }
        }
        return maxheap.isEmpty() ? 0 : maxheap.peek();
    }

    public int reverseBits(int n) {
        StringBuilder s = new StringBuilder();
        int x = n;
        for(int i = 0; i < 32; i++){
            if((x & 1) != 0){
                s.append('1');
            }
            else{
                s.append('0');
            }
            x = x >> 1;
        }
        s = s.reverse();
        int len = s.length();
        int ans = 0;
        for(int i = 0; i < len; i++){
            ans = (ans << 1) + (s.charAt(i) == '1' ? 1 : 0);
        }
        return ans;
    }
}
