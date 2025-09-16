package knapsack;

import java.util.Arrays;

public class paint_Problem {
   static int[][] t = new int[1001][1001];
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int n1 = time.length;
        for(int[] row : t){
            Arrays.fill(row,-1);
        }
        return paint_dp(0,n1,cost,time);
    }

    public static int paint_dp(int costindex , int wallremain,int[] cost,int[] time){
        if(wallremain <= 0){
            return 0;
        }

        if(t[costindex][wallremain] != -1){
            return t[costindex][wallremain];
        }
        else {
            int temp = Math.min(cost[costindex]+paint_dp(costindex+1,wallremain-time[costindex]-1,cost,time),paint_dp(costindex+1,wallremain,cost,time));
            t[costindex][wallremain] = temp;
        }
        return t[costindex][wallremain];
    }
}
