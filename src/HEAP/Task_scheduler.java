package HEAP;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Task_scheduler {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        pq.addAll(map.values());
        int count = 0;
        int k = 0;
        while(!pq.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                if(!pq.isEmpty()) {
                    int val = pq.peek();
                    pq.poll();
                    val -= 1;
                    list.add(val);
                }
            }
            for(int rem : list){
                if(rem > 0) {
                    pq.add(rem);
                }
            }
            if(!pq.isEmpty()){
                count += n+1;
            }
            else{
                count += list.size();
            }
        }
        return count;
    }
}
