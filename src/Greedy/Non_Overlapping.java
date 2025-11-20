package Greedy;

import java.util.Arrays;

public class Non_Overlapping {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int m = intervals[0].length;
        Arrays.sort(intervals,(row1,row2) -> Integer.compare(row1[1],row2[1]));
        int count = 1;
        int endinterval = intervals[0][1];
        for(int i = 1; i < n; i++){
            if(intervals[i][0] > endinterval){
                count += 1;
                endinterval = intervals[i][0];
            }
        }
        return n - count;
    }
}
