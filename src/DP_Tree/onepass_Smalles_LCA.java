package DP_Tree;

import HEAP.closet_point;

import java.util.HashMap;

public class onepass_Smalles_LCA {
    public Pair solve(TreeNode root) {
        if(root == null) {
            return new Pair(0, null);
        }

    var l = solve(root.left);
    var r = solve(root.right);

    if(l.depth == r.depth){
        return new Pair(l.depth + 1, root);
    }

    if(l.depth > r.depth){
        return new Pair(l.depth+ 1, l.Node);
    }
    return new Pair(r.depth + 1, r.Node);
}


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return solve(root).Node;
    }

    class Pair {
        int depth;
        TreeNode Node;

        public Pair(int depth, TreeNode Node) {
            this.depth = depth;
            this.Node = Node;
        }
    }
}
