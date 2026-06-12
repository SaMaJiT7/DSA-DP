package Trees;
import DP_Tree.TreeNode;

import java.awt.desktop.QuitEvent;
import java.util.ArrayDeque;
import java.util.Queue;

public class countNodes {
    public int countNodes(TreeNode root) {
//        if(root == null) return 0;
//        Queue<TreeNode> que = new ArrayDeque<>();
//        que.add(root);
//        int ans = 0;
//        while(!que.isEmpty()){
//            TreeNode node = que.poll();
//            ans++;
//            if(node.left != null) que.add(node.left);
//            if(node.right != null)que.add(node.right);
//        }
//
//        return ans;
        if(root == null) return 0;

        int lh = getleftheight(root);
        int rh =  getrightheight(root);

        if(lh == rh){
            return (1 << lh) - 1;
        }
        return countNodes(root.left) + 1 + countNodes(root.right);
    }

    private int getleftheight(TreeNode root) {
        if(root == null) return 0;
        return 1 + getleftheight(root.left);
    }
    private int getrightheight(TreeNode root) {
        if(root == null) return 0;
        return 1 + getrightheight(root.right);
    }
}
