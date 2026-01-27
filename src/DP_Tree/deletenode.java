package DP_Tree;

public class deletenode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left != null && root.right == null){
                return root.left;
            }
            else if(root.left == null && root.right != null){
                return root.right;
            }
            else{
                TreeNode successor = root.right;
                while(successor.left != null){
                    successor = successor.left;
                }
                root.val = successor.val;
                root.right = deleteNode(root.right,successor.val);
            }

        }
        else if(key < root.val){
            root.left = deleteNode(root.left,key);
        }
        else{
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
}
