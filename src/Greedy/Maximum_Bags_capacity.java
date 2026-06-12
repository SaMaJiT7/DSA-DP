package Greedy;

import java.util.Arrays;

public class Maximum_Bags_capacity {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] difference = new int[n];
        for(int i = 0; i < n; i++){
            difference[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(difference);
        int count = 0;
        for(int i = 0; i < n; i++){
            if(additionalRocks >= difference[i]){
                additionalRocks -= difference[i];
                count++;
            }
        }
        return count;
    }
}
