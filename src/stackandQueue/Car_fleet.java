package stackandQueue;

import java.util.Arrays;
import java.util.Stack;

public class Car_fleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n  = position.length;
        int[][] nums = new int[n][2];
        for(int i = 0 ; i < n; i++){
            nums[i][0] = position[i];
            nums[i][1] = speed[i];
        }
        Arrays.sort(nums,(a,b) -> Integer.compare(b[0],a[0]));
        Stack<Double> st = new Stack<>();
        for(int i = 0; i < n; i++){
            double TimetoReach = (double)(target - nums[i][0]) / nums[i][1];
            if(!st.isEmpty() && st.peek() >=  TimetoReach){
                continue;
            }
            else{
                st.push(TimetoReach);
            }
        }


        return st.size();
    }
}
