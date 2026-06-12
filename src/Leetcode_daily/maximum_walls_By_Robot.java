package Leetcode_daily;

import java.util.Arrays;

public class maximum_walls_By_Robot {
    int[][] t;
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int[][] merge = new int[n][2];
        int[][] range = new int[n][2];
        for(int i = 0; i < n; i++){
            merge[i][0] = robots[i];
            merge[i][1] = distance[i];
        }
        Arrays.sort(merge,(a,b) -> Integer.compare(a[0],b[0]));
        Arrays.sort(walls);
        for(int i = 0; i < n; i++){
            int pos = merge[i][0] ;
            int d = merge[i][1];
            int leftlimit = (i == 0) ? 1 : merge[i-1][0]+1;
            int rightlimit = (i == n-1) ? (int)1e9 : merge[i+1][0] - 1;
            range[i][0] = Math.max(pos - d,leftlimit); //L
            range[i][1] = Math.min(pos + d,rightlimit); //R
        }
        this.t = new int[n+1][2];
        for(int[] row : t){
            Arrays.fill(row,-1);
        }
        return solve(walls,merge,range,0,0);

    }

    public int solve(int[] walls,int[][] robotdist, int[][] range,int i, int prevdir){ // dir = 0 for L and 1 for R
        if(i == robotdist.length){
            return 0;
        }
        if(t[i][prevdir] != -1){
            return t[i][prevdir];
        }
        int leftstart = range[i][0];
        if(prevdir == 1 && i > 0){
            leftstart = Math.max(leftstart, range[i-1][1] + 1);
        }
        int lefttake = count(walls,leftstart,robotdist[i][0]) + solve(walls,robotdist,range,i+1,0);
        int righttake = count(walls,robotdist[i][0],range[i][1])+ solve(walls,robotdist,range,i+1,1);

        return t[i][prevdir] =Math.max(lefttake,righttake);
    }

    public int count(int[] walls,int L, int R){
        int n = walls.length;
        int lower = -1;
        int l = 0;
        int r = n-1;
        while(l <= r){
            int mid = l + (r-l)/2;

            if(walls[mid] >= L){
                lower = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        int upper = -1;
        l = 0;
        r = n-1;
        while(l <= r){
            int mid = l + (r-l)/2;

            if(walls[mid] <= R){
                upper = mid;
                l = mid + 1;
            }else{
                r = mid  - 1;
            }
        }

        if(lower == -1 || upper == -1 || lower > upper) return 0;
        return upper - lower + 1;
    }
}
