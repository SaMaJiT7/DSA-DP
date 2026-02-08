package DP_Tree;

import java.security.PrivateKey;
import java.util.Stack;

public class bst_iterator {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        BSTiterator l = new BSTiterator(root,false);
        BSTiterator r = new BSTiterator(root,true);
        int i = l.next();
        int j = r.next();
        while(i < j){
            if(i+j == k) return true;
            else if (i+j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
    public class BSTiterator{
        private Stack<TreeNode> st = new Stack<>();
        boolean reverse = true;

        public BSTiterator(TreeNode root, boolean reverse){
            this.reverse = reverse;
            PushAll(root);
        }

        public boolean hasnext(){
            return !st.isEmpty();
        }

        public int next(){
            TreeNode node = st.pop();
            if(reverse == false) PushAll(node.right);
            else PushAll(node.left);
            return node.val;
        }

        public void PushAll(TreeNode root){
            while(root != null){
                st.push(root);
                if(reverse == true){
                    root = root.right;
                }
                else{
                   root = root.left;
                }
            }
        }
    }
}
