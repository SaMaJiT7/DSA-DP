package DP_Tree;

public class same_tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        // If one is null but not the other → not same
        if (p == null || q == null) {
            return false;
        }

        // If current node values are different → not same
        if (p.val != q.val) {
            return false;
        }

        if(p.val == q.val){
            isSameTree(p.left,q.left);
            isSameTree(p.right,q.right);

        }
        else {
            return false;
        }
        return true;
    }
}
