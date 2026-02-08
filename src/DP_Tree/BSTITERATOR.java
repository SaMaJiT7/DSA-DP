package DP_Tree;

import java.util.Stack;

public class BSTITERATOR {
    private Stack<TreeNode> st = new Stack<>();
    public BSTITERATOR(TreeNode root){
        Pushall(root);
    }
    public int next() {
        TreeNode node = st.pop();
        if(node.right != null){
            Pushall(node.right);
        }
        return node.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
    public void Pushall(TreeNode root){
       while(root != null) {
           st.push(root);
           root = root.left;
       }
    }
}
