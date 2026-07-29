package DP_Tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        if (root == null) return "#,";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int q = queue.size();

            while(q-- > 0){
                TreeNode node = queue.poll();
                if(node != null){
                    s.append(node.val).append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                }
                else{
                    s.append("#,");
                }
            }
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        int i = 0;
        if(s[0].equals("#")) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(s[i]));
        queue.add(root);
        i +=1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(i < s.length) {
                if (!s[i].equals("#")) {
                    TreeNode left = new TreeNode(Integer.parseInt(s[i]));
                    node.left = left;
                    queue.add(left);
                }
                i++;
            }
            if(i < s.length) {
                if (!s[i].equals("#")) {
                    TreeNode right = new TreeNode(Integer.parseInt(s[i]));
                    node.right = right;
                    queue.add(right);
                }
                i++;
            }
        }
        return root;
    }
}
