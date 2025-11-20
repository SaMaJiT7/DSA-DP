package Two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class spell_porions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            long sp = spells[i];
            int left = 0;
            int right = m-1;
            int idx = m;

            while(left <= right){
                int mid = left + (right-left)/2;
                long strength = sp * potions[mid];
                if(strength >= success){
                    idx = mid;
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            ans[i] = m - idx;
        }
        return ans;
    }
}
