package Greedy;

import java.util.Arrays;

public class train_arrival {
    public int findPlatform(int[] Arrival, int[] Departure) {
        Arrays.sort(Arrival);
        Arrays.sort(Departure);
        int n = Arrival.length;
        int i = 0;
        int j = 0;
        int count = 0;
        int maxcount = 0;
        while(i < n){
            if(Arrival[i] <= Departure[j]){
                count = count + 1;
                i = i+1;
            }
            else{
                count = count - 1;
                j = j + 1;
            }
            maxcount = Math.max(maxcount,count);
        }
        return maxcount;
    }
}
