package Leetcode_daily;
import java.util.*;
public class Robot_collision {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] nums = new int[n][3]; // storing as {position,Health,direction}
        for(int i = 0; i < n; i++){
            nums[i][0] = positions[i];
            nums[i][1] = healths[i];
            if(directions.charAt(i) == 'L'){
                nums[i][2] = 0;
            }
            else{
                nums[i][2] = 1;
            }
            nums[i][3] = i;
        }

        Arrays.sort(nums,(a,b) -> Integer.compare(a[0],b[0]));
        Stack<int[]> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && st.peek()[2] == 1 && nums[i][2] == 0) {
                int[] prev = st.peek();
                if(prev[1] ==  nums[i][1]){
                    st.pop();
                    nums[i][1] = 0;
                    break;
                }
                else if(prev[1] < nums[i][1]){
                    st.pop();
                    nums[i][1]--;
                    continue;
                }
                else{
                    int[] top = st.peek();
                    top[1]--;
                    nums[i][1] = 0;
                    break;
                }
            }
            if(nums[i][1] > 0){
                st.push(new int[]{nums[i][0],nums[i][1],nums[i][2],nums[i][3]});
            }
        }

        List<Integer> Answer = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Answer.add(0);
        }
        while(!st.isEmpty()){
            Answer.set(st.peek()[3],st.pop()[1]);
        }
        List<Integer> res = new ArrayList<>();
        for(int val : Answer){
            if(val > 0) res.add(val);
        }
        return res;
    }
}
