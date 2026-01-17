package DP_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class right_side_Binary_tree {
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> results = new ArrayList<>();
//        if(root == null){
//            return results;
//        }
//        Queue<TreeNode> que = new LinkedList<>();
//        que.add(root);
//        TreeNode node = null;
//        while(!que.isEmpty()){
//            int n = que.size();
//            while(n-- > 0){
//                node = que.poll();
//                if (node.left != null) que.add(node.left);
//                if (node.right != null) que.add(node.right);
//            }
//            results.add(node.val);
//        }
//        return results;
//    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root,1,result);
        return result;
    }
    public void dfs(TreeNode root, int level,List<Integer> result){
        if(root == null){
            return;
        }
        if(result.size() < level){
            result.add(root.val);
        }
        dfs(root.right,level+1,result);
        dfs(root.left,level+1,result);
    }
}
