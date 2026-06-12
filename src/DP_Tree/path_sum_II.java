package DP_Tree;

import java.util.ArrayList;
import java.util.List;

public class path_sum_II {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        if(root == null) return result;
        int sum = 0;
        List<Integer> ans = new ArrayList<>();
        solve(root,targetSum,sum,ans);
        return result;
    }
    public void solve(TreeNode root, int targetSum,int sum,List<Integer> ans){
        if(root == null) return;

        sum += root.val;
        ans.add(root.val);


        if(root.left == null && root.right == null){
            if(sum == targetSum){
                result.add(new ArrayList<>(ans));
            }
            ans.remove(ans.size()-1);
            return;
        }

        solve(root.left,targetSum,sum,ans);
        solve(root.right,targetSum,sum,ans);
        ans.remove(ans.size()-1);
    }
}
