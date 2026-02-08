package DP_Tree;

import java.util.Stack;

public class BST_Preorder {
//    public TreeNode bstFromPreorder(int[] preorder) {
//        Stack<TreeNode> st = new Stack<>();
//        int n = preorder.length;
//        TreeNode root = new TreeNode(preorder[0]);
//        st.push(root);
//        for(int i = 1; i < n; i++){
//            TreeNode node = new TreeNode(preorder[i]);
//            if(node.val < st.peek().val){
//                st.peek().left = node;
//            }
//            else{
//                TreeNode parent = null;
//                while(!st.isEmpty() && node.val > st.peek().val){
//                    parent = st.pop();
//                }
//                parent.right = node;
//            }
//            st.push(node);
//        }
//        return root;
//    }
    int val = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,Integer.MAX_VALUE);
    }
    public TreeNode helper(int [] preorder, int upper_bound){
        if(val == preorder.length || preorder[val] > upper_bound){
            return null;
        }

        TreeNode root = new TreeNode(preorder[val++]);
        root.left = helper(preorder, root.val);
        root.right = helper(preorder,upper_bound);
        return root;
    }
}
