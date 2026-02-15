package GRID_DP;

import java.rmi.MarshalException;
import java.util.Arrays;

public class maxprofit_cooldown {
    int[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        this.dp = new int[n][2];
        for(int [] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,prices);
    }
    public int solve(int idx,int state,int[] prices){
        int profit = 0;
        if(idx >= prices.length){
            return 0;
        }
        if(dp[idx][state] != -1){
            return dp[idx][state];
        }

        if(state == 0){
            profit = Math.max(solve(idx+1,state,prices),-prices[idx] + solve(idx+1,state+1,prices));
        }
        else{
           profit = Math.max(solve(idx+1,state,prices),prices[idx] + solve(idx+2,0,prices));
        }
        return dp[idx][state] = profit;
    }
}
