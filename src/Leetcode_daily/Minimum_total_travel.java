package Leetcode_daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Minimum_total_travel {
    long[][] t;
    static long INF = (long)1e18;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int m = robot.size();
        int r = factory.length;
        Collections.sort(robot);
        Arrays.sort(factory,(a,b) -> Integer.compare(a[0],b[0]));
        List<Integer> factoposi = new ArrayList<>();
        for(int i = 0; i < r; i++){
            int limit = factory[i][1];
            int pos = factory[i][0];
            for(int j = 0; j < limit; j++){
                factoposi.add(pos);
            }
        }
        int n = factoposi.size();
        this.t = new long[m+1][n+1];
        for(long[] row : t){
            Arrays.fill(row,-1);
        }
        return solve(robot,factoposi,0,0,t);
    }
    public long solve(List<Integer> robot, List<Integer> factory,int ri, int fi,long[][] t){
        if(ri >= robot.size()) return 0;
        if(fi == factory.size()) return INF;

        if(t[ri][fi] != -1){
            return t[ri][fi];
        }

        long next = solve(robot, factory, ri + 1, fi + 1, t);
        long take = Long.MAX_VALUE;
        if (next != Long.MAX_VALUE) {
            take = Math.abs(factory.get(fi) - robot.get(ri)) + next;
        }
        long skip = solve(robot,factory,ri,fi+1,t);

        return t[ri][fi] = Math.min(take,skip);
    }
}
