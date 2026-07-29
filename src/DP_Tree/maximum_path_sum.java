package DP_Tree;

import com.sun.source.tree.Tree;

public class maximum_path_sum {
    int maxsum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        solve(root);
        return maxsum;
    }
    public int solve(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(0,solve(root.left));
        int right = Math.max(0,solve(root.right));

        maxsum = Math.max(maxsum,root.val+left+right);

        return root.val + Math.max(left,right);
    }
}
