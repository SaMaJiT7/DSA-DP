package Greedy;

import java.util.Arrays;

public class Dota_Senate {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        int R = 0;
        int D = 0;
        for(int i = 0; i < n; i++){
            if(senate.charAt(i) == 'R'){
                R++;
            }
            else{
                D++;
            }
        }
        if(R == 0 && D != 0){
            return "Dire";
        }
        if(R != 0 && D == 0){
            return "Radiant";
        }
        int idx = 0;
        boolean[] isban = new boolean[n];
        StringBuilder Senate = new StringBuilder(senate);
        Arrays.fill(isban,false);
        while(R > 0 && D > 0){
            if(!isban[idx]) {
                if (Senate.charAt(idx) == 'R') {
                    removeSenator((idx + 1) % n,isban,senate, 'D');
                    D--;
                } else {
                    removeSenator((idx + 1) % n, isban,senate, 'R');
                    R--;
                }
            }
            idx = (idx+1)%n;
        }
        return (R == 0 ? "Dire" : "Radiant");
    }
    void removeSenator(int idx,boolean[] isban, String senate,char Todelete){

        while(true){
            if(senate.charAt(idx) == Todelete && !isban[idx]){
                isban[idx] = true;
                break;
            }
            idx = (idx+1) % senate.length();
        }
    }
}
