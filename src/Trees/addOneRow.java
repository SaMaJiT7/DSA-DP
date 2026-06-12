package Trees;

import DP_Tree.TreeNode;

public class addOneRow {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return dfs(root,1,val,depth);
    }
    public TreeNode dfs(TreeNode node, int curr , int val, int depth){
        if(depth == 1){
            TreeNode root = new TreeNode(val);
            root.left = node;
            return root;
        }

        if(node == null) return null;

        if(curr == depth-1){
            TreeNode tempL = node.left;
            TreeNode tempR = node.right;
            TreeNode root = new TreeNode(val);
            TreeNode root2 = new TreeNode(val);
            node.left = root;
            node.right = root2;
            root.left = tempL;
            root2.right = tempR;
        }else{
            dfs(node.left,curr+1,val,depth);
            dfs(node.right,curr+1,val,depth);
        }
        return node;
    }
}
