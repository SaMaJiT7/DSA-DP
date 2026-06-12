package Leetcode_daily;

import java.util.Arrays;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        int[][] Score = new int[n][2];
        for(int i = 0; i < n ; i++){
            Score[i][0] = score[i];
            Score[i][1] = i;
        }
        Arrays.sort(Score,(a,b) -> Integer.compare(b[0],a[0]));
        for(int i = 0; i < n; i++){
            if(i == 0){
                ans[Score[i][1]] = "Gold Medal";
            }
            else if(i == 1){
                ans[Score[i][1]] = "Silver Medal";
            }
            else if(i == 2){
                ans[Score[i][1]] = "Bronze Medal";
            }
            else{
                ans[Score[i][1]] = String.valueOf(i+1);
            }
        }
        return ans;
    }
}
