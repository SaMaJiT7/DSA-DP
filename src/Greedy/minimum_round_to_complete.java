package Greedy;

import java.util.Arrays;
import java.util.HashMap;

public class minimum_round_to_complete {
    public int minimumRounds(int[] tasks) {
//        HashMap<Integer,Integer> Freq = new HashMap<>();
//        int n = tasks.length;
//        for(int i = 0; i < n; i++){
//            Freq.put(tasks[i],Freq.getOrDefault(tasks[i],0)+1);
//        }
//        int rounds = 0;
//        for(int val : Freq.values()){
//            if(val < 2) return -1;
//            rounds += (val+2)/3;
//        }
//        return rounds;
        int n = tasks.length;
        Arrays.sort(tasks);
        int prev = tasks[0];
        int count = 1;
        int rounds = 0;
        for(int i = 1; i < n; i++){
            if(prev == tasks[i]){
                count++;
            }
            else{
                if(count == 1){
                    return -1;
                }
                else{
                    rounds += (count+2)/3;
                    prev = tasks[i];
                    count = 1;
                }
            }
        }
        if(count == 1) return -1;
        rounds += (count + 2) / 3;
        return rounds;
    }
}
