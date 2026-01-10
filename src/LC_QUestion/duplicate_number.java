package LC_QUestion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class duplicate_number {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        int n2 = n / 2;
        for(int i = 0; i < n-2; i++){
            if(nums[i] == nums[i+1] || nums[i] == nums[i+2]){
                return nums[i];
            }
        }
        return nums[n-1];
    }

    public int repeatedNTimes0(int[] nums) {
        int n = nums.length;
        HashSet<Integer> unique = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(unique.contains(nums[i])){
                return nums[i];
            }else{
                unique.add(nums[i]);
            }
        }
        return nums[n-1];
    }
    public int repeatedNTimes9(int[] nums) {
        int n = nums.length;
        int n2 = n / 2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == n2) return entry.getKey();
        }
        return nums[n-1];
    }
}
