package LC_QUestion;

import java.util.*;

public class maximum_sum {
    public int[] maxKDistinct(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> map = new HashSet<>();
        List<Integer> list = new ArrayList<>(map);
        for(int i : nums){
            map.add(i);
        }
        Collections.sort(list);
        Collections.reverse(list);
        for (int i : list){
            if(ans.size() <= k) {
                ans.add(i);
            }
        }
        int[] arrnew = ans.stream().mapToInt(Integer::intValue).toArray();
        return arrnew;
    }
}
