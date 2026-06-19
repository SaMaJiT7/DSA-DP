package Digit_DP;

import java.util.ArrayDeque;
import java.util.Queue;

public class no_of_ones {
    Integer[][][] dp = new Integer[11][2][10];
    public int countDigitOne(int n) {
        String val = String.valueOf(n);
        return solve(val,0,1,0);
    }
    public int solve(String num, int idx,int tight,int count1){
        if(idx == num.length()){
            return count1;
        }
        if(dp[idx][tight][count1] != null){
            return dp[idx][tight][count1];
        }
        int upper = tight == 1 ? num.charAt(idx) - '0' : 9;

        int totalcount1 = 0;
        for(int d = 0; d <= upper; d++){
            int newtight = (tight == 1 && d == upper) ? 1 : 0;
            int newcount1 = (d == 1)  ? count1 + 1 : count1;

            totalcount1 += solve(num,idx+1,newtight,newcount1);
        }
        dp[idx][tight][count1] = totalcount1;
        return totalcount1;
    }
}
