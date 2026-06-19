package LC_QUestion;

import java.util.HashMap;

public class getLength {
    public int getLength(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            HashMap<Integer,Integer> freqValue = new HashMap<>();
            HashMap<Integer,Integer> freqCount = new HashMap<>();
            for(int j = i; j < n; j++){
                int oldfreq = freqValue.getOrDefault(nums[j],0);
                int newfreq = oldfreq+1;
                freqValue.put(nums[j],newfreq);
                if(freqCount.getOrDefault(oldfreq,0) > 0){
                    freqCount.put(oldfreq,freqCount.get(oldfreq)-1);
                    if(freqCount.get(oldfreq) == 0){
                        freqCount.remove(oldfreq);
                    }
                }
                freqCount.put(newfreq,freqCount.getOrDefault(newfreq,0)+1);

                boolean valid = isValid(freqCount,freqValue.size());

                if(valid){
                    max = Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }

    private static boolean isValid(HashMap<Integer, Integer> freqCount,int distinctValue) {
        boolean valid = false;
        if(freqCount.size() == 1 && distinctValue == 1){
            valid = true;
        }
        else if(freqCount.size() == 2){
            int f1 = Integer.MAX_VALUE;
            int f2 = Integer.MIN_VALUE;
            for(int val : freqCount.keySet()){
                f1 = Math.min(val,f1);
                f2 = Math.max(val,f2);
            }
            if(f2 == 2 * f1){
                valid = true;
            }
        }
        return valid;
    }
}
