package Leetcode_daily;

public class futthest_dist {
    public int furthestDistanceFromOrigin(String moves) {
//        int distL = 0;
//        //Taking _ as L and calculating dist
//        for(char ch : moves.toCharArray()){
//            if(ch == 'L'){
//                distL = distL - 1;
//            }
//            else if(ch == '_'){
//                distL = distL - 1;
//            }
//            else{
//                distL = distL + 1;
//            }
//        }
//
//        int distR = 0;
//        //Taking _ as R and calculating dist
//        for(char ch : moves.toCharArray()){
//            if(ch == 'R'){
//                distR = distR + 1;
//            }
//            else if(ch == '_'){
//                distR = distR + 1;
//            }
//            else{
//                distR = distR - 1;
//            }
//        }
//
//        return Math.max(Math.abs(distL),Math.abs(distR));
        int cntL = 0;
        int cntR = 0;
        int blank = 0;
        int n = moves.length();
        for(char ch : moves.toCharArray()){
            if(ch == 'L'){
                cntL = cntL + 1;
            }
            else if(ch == 'R'){
                cntR = cntR + 1;
            }
            else{
                blank = blank + 1;
            }
        }
        if(cntL == cntR){
            return (n-(cntR+cntL));
        }
        else if(cntL < cntR){
            return ((blank + cntR) - cntL);
        }
        else{
            return ((blank + cntL) - cntR);
        }
    }
}
