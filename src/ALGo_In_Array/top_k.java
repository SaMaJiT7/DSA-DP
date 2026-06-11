package ALGo_In_Array;

import java.util.*;

public class top_k {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int element = entry.getKey();
            int freq = entry.getValue();
            arr.add(new int[]{element,freq});
        }

        Collections.sort(arr,(a,b) -> Integer.compare(b[1],a[1]));
        int[] answer = new int[k];
        for(int i = 0; i < k; i++){
            answer[i] = arr.get(i)[0];
        }
        return answer;
    }
}
