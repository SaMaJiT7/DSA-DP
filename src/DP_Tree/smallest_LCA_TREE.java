package DP_Tree;

import java.util.HashMap;

public class smallest_LCA_TREE {
    HashMap<Integer,Integer> map;
    int maxD = -1;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // 1. Initialize data structures here, once per problem call
        map = new HashMap<>();
        maxD = -1;

        depth(root,0);
        return LCA(root);
    }
    public void depth(TreeNode root, int d){
        if(root == null){
            return;
        }
        maxD = Math.max(maxD,d);
        map.put(root.val,d);
        depth(root.left,d+1);
        depth(root.right,d+1);
    }
    public TreeNode LCA(TreeNode root){

        if(root == null || map.get(root.val) == maxD){
            return root;
        }

        TreeNode leftN = LCA(root.left);
        TreeNode rightN = LCA(root.right);

        if(leftN != null && rightN != null){
            return root;
        }

        if(leftN != null && rightN == null)
            return leftN;
        return rightN;
    }
}
