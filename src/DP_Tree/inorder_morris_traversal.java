package DP_Tree;

import java.util.ArrayList;
import java.util.List;

public class inorder_morris_traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> Inorder = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null){
            if(curr.left == null){
                Inorder.add(curr.val);

                curr = curr.right;
            }
            else{
                TreeNode leftchild = curr.left;

                while(leftchild.right != null){
                    leftchild = leftchild.right;
                }

                leftchild.right = curr;

                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return Inorder;
    }
}
