package ALGo_In_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class toggle_light {
    /*
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        int n = bulbs.size();
        List<Integer> active = new ArrayList<>();
        for(int i : bulbs){
            if(!active.contains(i)){
                active.add(i);
            }
            else{
                active.remove(Integer.valueOf(i));
            }
        }
        Collections.sort(active);
        return active;
    } */
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        int[] button = new int[101];
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(button,0);
        for(int i : bulbs){
            if(button[i] == 0){
                button[i] = 1;
            }else{
                button[i] = 0;
            }
        }

        for(int i = 1; i < 101; i++){
            if(button[i] == 1){
                ans.add(i);
            }
        }
        return ans;
    }
}
