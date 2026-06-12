package Leetcode_daily;

import java.util.Arrays;

public class score_parity {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int odd = 0;
        int even = 0;
        for(int i = 0; i < n; i++){
            if((nums[i] & 1) == 0){
                answer[i] = odd;
                even++;
            }
            else{
                answer[i] = even;
                odd++;
            }
        }
        return answer;
    }
}
