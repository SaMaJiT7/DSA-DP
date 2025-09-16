package knapsack;

public class Min_cost_climbing {
    public int minCostClimbingStairs(int[] cost) {
        int[] t = new int[cost.length+1];

        int n = cost.length-1;
        t[n] = 0;

        t[0] = 1;
        t[1] = 1;

        for(int i  = 2; i < cost.length;i++){
            t[i] = t[i-1] + t[i-2];
        }
        return t[n];
    }
}
