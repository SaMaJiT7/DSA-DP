package LC_QUestion;

import java.util.Arrays;

public class maximum_sqr_area {
    //public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
//        n = n + 2;
//        m = m + 2;
//        Arrays.sort(hBars);
//        Arrays.sort(vBars);
//        int sq = Math.min(maxspan(hBars),maxspan(vBars));
//        return sq * sq;
//    }
//    public int maxspan(int[] bars){
//        int res = 1;
//        int expand = 1;
//        for(int i = 0; i < bars.length-1;i++){
//            if(bars[i+1] - bars[i] == 1) expand++;
//            else expand = 1;
//            res = Math.max(res,expand);
//        }
//        return res;
//    }
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int max_height = 0;
        int max_breath = 0;
        int expand = 0;
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        for(int i = 0; i < hBars.length-1; i++){
            if(hBars[i+1] - hBars[i] == 1)expand++;
            else expand = 0;
        }
        max_breath = Math.max(max_breath,expand);

        expand = 0;
        for(int i = 0; i < vBars.length-1; i++){
            if(vBars[i+1] - vBars[i] == 1)expand++;
            else expand = 0;
        }
        max_height = Math.max(max_height,expand);


        int sq = Math.min(max_height,max_breath) + 2;

        return sq * sq;
    }
}
