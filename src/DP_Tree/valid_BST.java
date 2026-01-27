package DP_Tree;

public class valid_BST {
    TreeNode parent = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if (!isValidBST(root.left)) return false;

        if(parent != null) {
            if (root.val <= parent.val) {
                return false;
            }
        }
        parent = root;

        if (!isValidBST(root.right)) return false;;
        return true;
    }
}
