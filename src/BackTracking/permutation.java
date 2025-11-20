package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> processed = new ArrayList<>();
        List<Integer> unprocessed = new ArrayList<>();
        for (int n : nums) unprocessed.add(n);
        return helper(processed,unprocessed);
    }

    static List<List<Integer>> helper(List<Integer> p,List<Integer> up){
        if(up.isEmpty()){
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(p));
            return ans;
        }
        int num = up.remove(0);
        List<List<Integer>> result = new ArrayList<>();

        // Insert 'num' at every possible position in 'processed'
        for (int i = 0; i <= p.size(); i++) {
            p.add(i, num);  // Insert at position i
            result.addAll(helper(p,up));  // Recurse
            p.remove(i);  // Backtrack: remove the inserted element
        }
        up.add(0, num);  // Restore unprocessed for backtracking
        return result;
    }
}
