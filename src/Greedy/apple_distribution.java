package Greedy;

import java.util.Arrays;
import java.util.Collections;

public class apple_distribution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int m = capacity.length;
        int count = 0;
        int sum = 0;
        for(int i = 0; i < apple.length; i++){
            sum += apple[i];
        }
        Arrays.sort(capacity);
        for(int i = m-1; i >= 0; i--){
            if(sum > 0){
                sum = sum - capacity[i];
                count++;
            }
        }
        return count;
    }
}
