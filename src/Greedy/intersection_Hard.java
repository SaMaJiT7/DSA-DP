package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intersection_Hard {
    public int intersectionSizeTwo(int[][] intervals) {
        int prev1 = -1;
        int prev2 = -1;
        int count = 0;

        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return b[0] - a[0]; // start DESCENDING
        });

        for(int[] row : intervals) {
            int s = row[0];
            int e = row[1];

            if (prev2 >= s && prev1 >= s) {
                continue;
            }

            if(prev2 >= s && !(prev1 >= s)) {
                count++;
                prev1 = prev2;
                prev2 = e;
            } else {
                count += 2;
                prev1 = e - 1;
                prev2 = e;
            }
        }
        return count;
    }
}
