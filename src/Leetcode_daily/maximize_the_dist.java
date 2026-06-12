package Leetcode_daily;

import java.util.*;

public class maximize_the_dist {
    int n;
    long perimeter;
    public int maxDistance(int side, int[][] points, int k) {
        long lside = (long) side;
        this.perimeter = 4 * lside;
        this.n = points.length;
        long[] pos = new long[n];
        for(int i = 0; i < n; i++){
            int x = points[i][0];
            int y = points[i][1];
            long p = 0;
            if(x == 0) p = y;
            else if(y == side) p = lside + x;
            else if(x == side) p = 3 * lside - y;
            else p = 4 * lside - x;
            pos[i] = p;
        }
        Arrays.sort(pos);
        long[] doubled = new long[2*n];
        for(int i = 0; i < n; i++){
            doubled[i] = pos[i];
            doubled[i+n] = pos[i] + perimeter;
        }

        int low = 0;
        int high = 2 * side;
        int ans = 0;
        while(low <= high){
            int d = low + (high-low)/2;

            if(check(d,doubled,k,side)){
                ans = d;
                low = d + 1;
            }
            else{
                high = d - 1;
            }
        }
        return ans;
    }
    public boolean check(int d,long[] doubled, int k, int side){
        int m = doubled.length;
        for (int i = 0; i < n; i++) {
            int count = 1;
            int idx  = i;

            long lastpos = doubled[idx];
            for (int j = 2; j <= k; j++) {
                long target = lastpos + d;

                idx = Arrays.binarySearch(doubled, target);
                if (idx < 0)
                    idx = -(idx + 1);
                if (idx == m)
                    return false;

                lastpos = doubled[idx];
                count++;
            }

            if (count == k && (doubled[i] + perimeter - lastpos >= d)) {
                return true;
            }
        }
        return false;
    }

}
