package stackandQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class stock_span {
    private Stack<Pair> st;
    private int index;
    public void StockSpanner() {
        st = new Stack<>();
        index = 0;
    }

    public int next(int price) {
        index++;
        int previndex = 0;
        List<Integer> ans = new ArrayList<>();
        while(!st.isEmpty() && price >= st.peek().first){
            st.pop();
        }

        if(st.isEmpty()){
            previndex = 0;
        }
        else{
            previndex = st.peek().second;
        }
        int span = index - previndex;

        st.push(new Pair(price, index));

        return span;
    }

    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
