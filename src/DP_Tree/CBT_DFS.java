package DP_Tree;

import com.sun.source.tree.Tree;

public class CBT_DFS {
    public boolean isCompleteTree(TreeNode root) {
        int count = countnodes(root);
        int i = 0;
       return dfs(root,i,count);
    }
    public int countnodes(TreeNode root){
        if(root == null){
            return 0;
        }
        TreeNode lefttree = root.left;
        TreeNode rightree = root.right;
        return 1 + countnodes(lefttree)+countnodes(rightree);
    }
    public boolean dfs(TreeNode root,int idx,int totalcount){
        if(root == null){
            return true;
        }
        if(idx >= totalcount){
            return false;
        }

        return dfs(root.left,2*idx+1,totalcount) && dfs(root.right,2*idx+2,totalcount);
    }
}
