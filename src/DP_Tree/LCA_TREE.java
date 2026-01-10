package DP_Tree;

public class LCA_TREE {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return  root;
        }
        TreeNode LeftN = lowestCommonAncestor(root.left,p,q);
        TreeNode RightN = lowestCommonAncestor(root.right,p,q);

        if(LeftN != null && RightN != null){
            return root;
        }
        if(LeftN != null && RightN == null)
            return LeftN;

        return RightN;
    }
}
