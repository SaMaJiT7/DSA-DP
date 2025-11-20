package DP_Tree;


public class balanced_tree {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) !=-1;
    }
    public int dfsHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftheight = dfsHeight(root.left);
        if(leftheight == -1) return  -1;
        int rightheight = dfsHeight(root.right);
        if(rightheight == -1) return -1;


        if(Math.abs(leftheight - rightheight) > 1) return -1;

        return Math.max(leftheight,rightheight) + 1;
    }
}
