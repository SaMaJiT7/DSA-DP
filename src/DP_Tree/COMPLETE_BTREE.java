package DP_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class COMPLETE_BTREE {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        boolean past = false;
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            if(node == null){
                past = true;
            }else{
                if(past){
                    return false;
                }
                que.add(node.left);
                que.add(node.right);
            }
        }
        return true;
    }
}
