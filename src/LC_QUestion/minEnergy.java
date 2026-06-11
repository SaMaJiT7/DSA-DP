package LC_QUestion;

import java.util.Arrays;

public class minEnergy {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        int l = intervals.length;
        long ans = 0;
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int bulbsOn = Math.ceilDiv(brightness,3);
        int curr = -1;
        for(int[] interval : intervals){
            if(curr >= interval[1]){
                continue;
            }
            if(curr >= interval[0]){
                interval[0] = curr+1;
            }
            curr = interval[1];
            long time = interval[1] - interval[0]  + 1;
            ans += time * bulbsOn;
        }
        return ans;
    }
}
