package stackandQueue;

import java.util.Stack;

public class daily_temperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<int[]> st = new Stack<>();
        for(int i = n-1; i >=0 ; i--){
            if(!st.isEmpty() && st.peek()[0] <= temperatures[i]){
                while(!st.isEmpty() && st.peek()[0] <= temperatures[i]){
                    st.pop();
                }
            }
            if(st.isEmpty()){
                answer[i] = 0;
            }
            else if(st.peek()[0] > temperatures[i]){
                answer[i] = st.peek()[1] - i;
            }
            st.push(new int[]{temperatures[i],i});
        }

        return answer;
    }
}
