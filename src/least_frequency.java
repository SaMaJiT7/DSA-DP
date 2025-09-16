import java.util.*;

public class least_frequency {
    public int getLeastFrequentDigit(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> keys = new ArrayList<>();
        while(n > 0){
            int digit = n % 10;
            map.put(digit, map.getOrDefault(digit,0)+1);
            n = n / 10;
        }
        if(map.isEmpty()){
            return 0;
        }
        for (int freq : map.values()) {
            min = Math.min(min, freq);
        }

        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) {
                keys.add(entry.getKey());
            }
        }
        return Collections.min(keys);
    }
}
