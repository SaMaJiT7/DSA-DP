package BackTracking;

import java.util.Arrays;
import java.util.Collections;

public class matchsticks {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        Arrays.sort(matchsticks);
        int low = 0;
        int high = n-1;
        while(low < high){
            int temp = matchsticks[low];
            matchsticks[low] = matchsticks[high];
            matchsticks[high] = temp;
            low++;
            high--;
        }
        int total = 0;
        for(int i = 0; i < n; i ++){
            total += matchsticks[i];
        }
        int target = total / 4;
        int[] sidesum = new int[4]; // 0 - left , 1 - top , 2 - right, 3 - bottom.
        return solve(0,matchsticks,sidesum,target,n);
    }
    public boolean solve(int curr,int[] match,int[] sidesum,int target,int n){
        if(curr == n){
            return true;
        }

        int len = match[curr];
        for(int i = 0; i < 4; i++){
            if(i > 0 && sidesum[i] == sidesum[i-1]) continue;
            int nl = sidesum[i] + len;
            if(nl <= target){
                sidesum[i] = nl; // pick the matchstick
                if(solve(curr+1,match,sidesum,target,n)){ // explore
                    return true;
                }
                sidesum[i] -= len; //backtrack
                if (sidesum[i] == 0) break;
            }
        }
        return false;
    }
}
