package Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class avoid_rain {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans,1);
        HashMap<Integer,Integer> lakeday = new HashMap<>();
        TreeSet<Integer> dryday = new TreeSet<>();

        for(int i = 0; i < n; i++){
            int lake = rains[i];
            if(lake == 0){
                dryday.add(i);
            }
            else{
                ans[i] = -1;
                if(lakeday.containsKey(lake)){
                    Integer dryDay = dryday.higher(lakeday.get(lake)); // same as upper_bound
                    if (dryDay == null) return new int[0];
                    ans[dryDay] = lake;
                    dryday.remove(dryDay);
                }
                lakeday.put(lake,i);
            }
        }
//        for (int day : dryday) {
//            ans[day] = 1;
//        }
        return ans;
    }
}
