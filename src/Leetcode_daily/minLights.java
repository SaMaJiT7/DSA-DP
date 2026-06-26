package Leetcode_daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class minLights {
    public int minLights(int[] lights) {
        int n = lights.length;
        List<int[]> intervals = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(lights[i] != 0){
                int start = Math.max(0,i-lights[i]);
                int end = Math.min(n-1,i+lights[i]);
                intervals.add(new int[]{start,end});
            }
        }
        if (intervals.isEmpty()) return (n + 2) / 3;
        Collections.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> merged = new ArrayList<>();
        int start = intervals.get(0)[0];
        int end = intervals.get(0)[1];
        for(int i = 1; i < intervals.size(); i++){
            if(end >= intervals.get(i)[0]){
                end = Math.max(end,intervals.get(i)[1]);
            }
            else{
                merged.add(new int[]{start,end});
                start = intervals.get(i)[0];
                end = intervals.get(i)[1];
            }
        }
        merged.add(new int[]{start,end});

        int bulb = getBulb(merged,n);

        return bulb;
    }

    private static int getBulb(List<int[]> merged,int n) {
        int bulb = 0;
        if (merged.get(0)[0] > 0) {
            int len = merged.get(0)[0];
            bulb += (len + 2) / 3;
        }

        for(int i = 0; i < merged.size()-1; i++){
            int curr = merged.get(i)[1];
            int next = merged.get(i+1)[0];

            if(next > curr + 1){
                int gapstart = curr + 1;
                int gapend = next - 1;

                int length = gapend - gapstart + 1;

                bulb += (length + 2) / 3;
            }
        }
        if(merged.get(merged.size()-1)[1] < n-1){
            int len = (n-1) - merged.get(merged.size()-1)[1];
            bulb += (len + 2) / 3;
        }

        return bulb;
    }
}
