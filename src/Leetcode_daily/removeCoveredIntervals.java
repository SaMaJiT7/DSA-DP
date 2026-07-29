package Leetcode_daily;

import java.util.Arrays;

public class removeCoveredIntervals {
//    public int removeCoveredIntervals(int[][] intervals) {
//        int n = intervals.length;
//        Arrays.sort(intervals,(a,b) -> (a[0] == b[0] ? Integer.compare(b[1],a[1]) : Integer.compare(a[0],b[0])));
//        int totalIntervals = 0;
//        int maxEnd = 0;
//        for (int i = 0; i < n; i++) {
//            if(intervals[i][1] > maxEnd){
//                totalIntervals += 1;
//                maxEnd = intervals[i][1];
//            }
//        }
//        return totalIntervals;
//    }
}
