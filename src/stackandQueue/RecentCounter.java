package stackandQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class RecentCounter {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
    Queue<Integer> que;
    public RecentCounter() {
        que = new ArrayDeque<>();
    }

    public int ping(int t) {
        que.add(t);
        int l = t-3000;
        int r = t;

        if(!que.isEmpty() && que.peek() < l){
            while (!que.isEmpty() && que.peek() < l){
                que.poll();
            }
        }
        return que.size();
    }
}
