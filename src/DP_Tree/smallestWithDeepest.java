package DP_Tree;

public class smallestWithDeepest {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return solve(root).node;
    }
    public Treepair solve(TreeNode root){
        if(root == null){
            return new Treepair(0,null);
        }
        Treepair left = solve(root.left);
        Treepair right = solve(root.right);

        if(left.depth == right.depth){
            return new Treepair(left.depth+1,root);
        }
        else if(left.depth > right.depth){
            return new Treepair(left.depth+1,left.node);
        }
        else{
            return new Treepair(right.depth+1,right.node);
        }
    }
}
class Treepair{
    int depth;
    TreeNode node;
    public Treepair(int depth,TreeNode node){
        this.depth = depth;
        this.node = node;
    }
}
