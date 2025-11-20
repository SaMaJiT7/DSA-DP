package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutation_iI {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> permute = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(nums,used,ans,permute);
        return permute;
    }
    static void helper(int[] nums,boolean[] used,List<Integer> ans,List<List<Integer>> permute){
        if(ans.size() == nums.length){
            permute.add(new ArrayList<>(ans));
            return;
        }

        for(int i = 0; i < nums.length;i++) {
            if (used[i]) continue;


            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            ans.add(nums[i]);
            used[i] = true;

            helper(nums, used, ans, permute);

            ans.remove(ans.size() - 1);
            used[i] = false;
        }
    }
}
