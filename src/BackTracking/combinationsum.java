package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class combinationsum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combisum = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int index = 0;
        helper(index,target,candidates,ans,combisum);
        return combisum;
    }

    static void helper(int index , int target,int[] candidates,List<Integer> ans, List<List<Integer>> combisum){
        if(target == 0){
            combisum.add(new ArrayList<>(ans));
            return;
        }

        if(index == candidates.length || target < 0){
            return;
        }
        helper(index+1,target,candidates,ans,combisum);

        ans.add(candidates[index]);
        if(candidates[index] <= target) {
            helper(index, target - candidates[index], candidates, ans, combisum);
        }
        ans.remove(ans.size() - 1);
    }
}
