package Greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class dota_senateQueue {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> DireQue = new LinkedList<>();
        Queue<Integer> RadiantQue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(senate.charAt(i) == 'R'){
                RadiantQue.add(i);
            }
            else{
                DireQue.add(i);
            }
        }

        int lastidx = n-1;
        while(!DireQue.isEmpty() && !RadiantQue.isEmpty()){
            int rad = RadiantQue.remove();
            int dir = DireQue.remove();

            if(rad < dir){
                RadiantQue.add(lastidx++);
            }
            else{
                DireQue.add(lastidx++);
            }
        }
       return (DireQue.isEmpty()) ? "Radiant" : "Dire";
    }
}
