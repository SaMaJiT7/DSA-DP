package DP_Tree;

public class pruning_tree {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        if(!isonepresent(root.left)) {
            root.left = null;
        }
        if(!isonepresent(root.right)){
            root.right = null;
        };

        pruneTree(root.left);
        pruneTree(root.right);
        if(root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
    }
    public boolean isonepresent(TreeNode root){
        if(root == null){
            return false;
        }

        if(root.val == 1){
            return true;
        }
        return isonepresent(root.left) || isonepresent(root.right);
    }
}
