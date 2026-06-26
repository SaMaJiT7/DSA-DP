package Binary_Lifting;

import javax.swing.tree.TreeCellRenderer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LCA {
    int[][] up;
    int LOG;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        int n = height(root);
        this.LOG = (int) (Math.ceil(Math.log(n) / Math.log(2)) + 1);
        this.up = new int[n+1][LOG];
        for(int[] val : up){
            Arrays.fill(val,-1);
        }
        up[root.val][0] = -1;


    }
    public int height(TreeNode root){
        if(root == null) return 0;
        int count = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            TreeNode curr = que.poll();
            count++;

            if(curr.left != null){
                que.add(curr.left);
            }

            if(curr.right != null){
                que.add(curr.right);
            }
        }

        return count;
    }
}
