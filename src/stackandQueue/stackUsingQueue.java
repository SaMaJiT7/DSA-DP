package stackandQueue;

import java.util.LinkedList;
import java.util.Queue;

public class stackUsingQueue {
    Queue<Integer> Q1;
    public stackUsingQueue() {
        Q1 = new LinkedList<>();
    }

    public void push(int x) {
       Q1.add(x);
       for(int i = 0; i < Q1.size()-1; i++){
           Q1.add(Q1.poll());
       }
    }

    public int pop() {
        return Q1.poll();
    }

    public int top() {
        return Q1.peek();
    }

    public boolean empty() {
        return Q1.isEmpty();
    }
}
