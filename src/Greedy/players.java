package Greedy;

import java.util.Arrays;

public class players {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n = players.length;
        int m = trainers.length;
        int i = 0;
        int j = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);

        while(i < n && j < m){
            if(players[i] <= trainers[j]){
                i = i + 1;
                j++;
            }
            else{
                j = j + 1;
            }
        }
        return i;
    }
}
