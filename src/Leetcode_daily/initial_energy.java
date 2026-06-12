package Leetcode_daily;

import java.util.Arrays;

public class initial_energy {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        Arrays.sort(tasks,(a,b) -> {
            int d1 = a[1]-a[0];
            int d2 = b[1]-b[0];
            if(d1 == d2){
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(d2,d1);
        });
        int low = 0;
        int high = 0;
        for(int i = 0; i < n; i++){
            high += tasks[i][1];
        }
        int ans = 0;
        while(low < high){
            int mid = low + (high-low)/2;

            if(isValid(mid,tasks,n)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }
    public boolean isValid(int energy, int[][] tasks, int n){
        int val = energy;
        for(int i = 0; i < n; i++){
            if(val < tasks[i][1]) {
                return false;
            }
            val = val - tasks[i][0];
        }
        return true;
    }
}
