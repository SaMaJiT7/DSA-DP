package DP_Tree;

public class path_sum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        TreeNode Node = root;
        int sum = 0;

        boolean ans = solve(root,sum,targetSum);

        return ans;
    }
    public static boolean solve(TreeNode root, int sum, int targetSum){
        if(root == null){
            return false;
        }

        sum += root.val;

        if(root.left == null && root.right == null){
            if(sum == targetSum){
                return true;
            }
            return false;
        }

        boolean left = solve(root.left,sum,targetSum);
        boolean right = solve(root.right,sum,targetSum);

        return left || right;
    }
}
