package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Post_Order {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> PostOrder = new ArrayList<>();
            Stack<TreeNode> st1 = new Stack<TreeNode>();
            Stack<TreeNode> st2 = new Stack<TreeNode>();
            TreeNode node = root;

            if(root == null){
                return PostOrder;
            }
            st1.push(root);
            while(!st1.isEmpty()){
                root = st1.pop();
                st2.push(root);
                if(root.left != null){
                    st1.push(root.left);
                }
                if(root.right != null){
                    st2.push(root.right);
                }
            }
            while(!st2.isEmpty()){
                PostOrder.add(st2.pop().val);
            }
            return PostOrder;
        }
}
