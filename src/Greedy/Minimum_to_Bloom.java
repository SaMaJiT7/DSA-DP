package Greedy;

import java.util.Arrays;

public class Minimum_to_Bloom {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int[][] merge = new int[n][2];
        for(int i = 0; i < n; i++){
            merge[i][0] = plantTime[i];
            merge[i][1] = growTime[i];
        }
        Arrays.sort(merge,(a,b) -> Integer.compare(b[1],a[1]));
        int MaxBloomdays = 0;
        int prevplantdays = 0;
        for(int[] curr : merge){
            int plant = curr[0];
            int grow = curr[1];

            prevplantdays += plant;
            int bloomtime = prevplantdays + grow;


            if(bloomtime > MaxBloomdays ){
                MaxBloomdays = bloomtime;
            }
        }
        return MaxBloomdays;
    }
}
