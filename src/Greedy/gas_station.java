package Greedy;

import jdk.jshell.Snippet;

import java.util.Arrays;

public class gas_station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int m = cost.length;
        int start = 0;
        int totalfuel = 0;
        int currentfuel = 0;

        if (n != m) return -1;

        for(int i = 0; i < n ; i++){
            int fuelreq = gas[i] - cost[i];
            totalfuel += fuelreq;
            currentfuel += fuelreq;

            if(currentfuel < 0){
                start = i+1;
                currentfuel = 0;
            }
        }
        return totalfuel >= 0 ? start : -1;
    }
}
