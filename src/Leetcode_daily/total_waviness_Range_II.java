package Leetcode_daily;

import jdk.management.jfr.FlightRecorderMXBean;

public class total_waviness_Range_II {
    Pair[][][][][] dp;
    public long totalWaviness(long num1, long num2) {
        if(num2 < 100){
            return 0;
        }
        if(num1 < 100){
            num1 = 100;
        }
        String r = String.valueOf(num2);
        String l = String.valueOf(num1-1);
        dp = new Pair[r.length()][2][11][11][2];
        long answer = solve(r,0,1,10,10,1).sum;
        dp = new Pair[l.length()][2][11][11][2];
        long answer2 = solve(l,0,1,10,10,1).sum;

        return  answer-answer2;
    }
    public Pair solve(String num,int idx,int tight,int prev1, int prev2,int lz){
        long totalcount = 0;
        long totalsum = 0;

        if(idx == num.length()){
            return new Pair(1,0);
        }
        int upper = tight == 1 ? num.charAt(idx) - '0' : 9;

        if(dp[idx][tight][prev1][prev2][lz] != null){
            return dp[idx][tight][prev1][prev2][lz];
        }
        for(int d = 0; d <= upper; d++){
            int newtight = (tight == 1 && d == upper) ? 1 : 0;
            int newlz = (lz == 1 && d == 0) ? 1 : 0;

            int add = 0;

            if(prev1 != 10 && prev2 != 10){
                if((prev2  < d && prev2 < prev1) || (prev2  > d && prev2 > prev1)){
                    add = 1;
                }
            }
            int newPrev1;
            int newPrev2;
            if(lz == 1 && d == 0){
                newPrev1 = 10;
                newPrev2 = 10;
            }
            else {
                newPrev1 = prev2;
                newPrev2 = d;
            }
            Pair next = solve(num,idx+1,newtight,newPrev1,newPrev2,newlz);

            totalcount += next.count;
            totalsum += next.sum;
            totalsum += add * next.count;
        }
        Pair result = new Pair(totalcount, totalsum);
        dp[idx][tight][prev1][prev2][lz] = result;
        return result;
    }
    class Pair{
        long count;
        long sum;

        public Pair(long cnt,long sum){
            this.count = cnt;
            this.sum = sum;
        }
    }
}
