package DP_Tree;

public class insertBST {
//    public TreeNode insertIntoBST(TreeNode root, int val) {
//        if(root == null){
//            root = new TreeNode(val);
//            return root;
//        }
//        if(val < root.val){
//            root.left = insertIntoBST(root.left,val);
//        }
//        else if(val > root.val){
//            root.right = insertIntoBST(root.right,val);
//        }
//        return root;
//    }
public TreeNode insertIntoBST(TreeNode root, int val) {
    if(root == null){
        return new TreeNode(val);
    }
    TreeNode curr = root;
    TreeNode parent = null;
    while(curr != null) {
        if (val < curr.val) {
            parent = curr;
            curr = curr.left;
        } else if (val > curr.val) {
            parent = curr;
            curr = curr.right;
        }
    }
    if (val < parent.val) {
        parent.left = new TreeNode(val);
    }
    else{
        parent.right = new TreeNode(val);
    }
    return root;
}
}
