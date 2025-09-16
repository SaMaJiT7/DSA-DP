package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination_sumii {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combisum2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,target,candidates,ans,combisum2);
        return combisum2;
    }
    static void helper(int start,int target,int[] candidates,List<Integer> ans,List<List<Integer>> combisum2) {
        if (target == 0) {
            combisum2.add(new ArrayList<>(ans));
            return;
        }
        if (start == candidates.length || target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // Prune if current candidate is too large
            if (candidates[i] > target) {
                break;
            }
            ans.add(candidates[i]);
            helper(i + 1, target - candidates[i], candidates, ans, combisum2);
            ans.remove(ans.size() - 1);
        }
    }
}
