package Leetcode_daily;

import java.util.Arrays;

public class min_cost_to_candy {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        Arrays.sort(cost);
        int count = 0;
        int minCost = 0;
        for(int i = n-1; i >= 0; i--){
            if(count == 2){
                count = 0;
                continue;
            }
            count++;
            minCost += cost[i];
        }
        return minCost;
    }
}
