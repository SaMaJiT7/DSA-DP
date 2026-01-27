package DP_Tree;

import java.util.Stack;

public class kth_smallest {
    int ans = 0;
    int result = -1;
//    public int kthSmallest(TreeNode root, int k) {
//          inorder(root,k);
//          return result;
//    }
//    public void inorder(TreeNode root, int k){
//        if(root == null) return;
//
//
//        inorder(root.left,k);
//        ans++;
//        if(ans == k){
//            result = root.val;
//            return;
//        }
//
//        inorder(root.right,k);
//    }

    public int kthSmallest(TreeNode root, int k) {
          Stack<TreeNode> st = new Stack<>();
          TreeNode curr = root;

          while(curr != null || !st.isEmpty()){
              while(curr != null){
                  st.push(curr);
                  curr = curr.left;
              }

              curr = st.pop();
              k--;
              if(k == 0) return curr.val;

              curr = curr.right;
          }
          return -1;
    }
}
