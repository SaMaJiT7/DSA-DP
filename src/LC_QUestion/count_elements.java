package LC_QUestion;

import java.util.HashMap;
import java.util.Map;

public class count_elements {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int count = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (int value : map.values()) {
            max = Math.max(max,value);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
           if(entry.getValue() == max){
               count += 1;
           }
        }
        return count * max;
    }
}
