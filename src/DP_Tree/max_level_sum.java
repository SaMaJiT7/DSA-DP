package DP_Tree;

import java.util.*;

public class max_level_sum {
    static HashMap<Integer,Integer> list;
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        int minindex = 0;
        int maxsum = Integer.MIN_VALUE;

        que.add(root);
        int currlvl = 1;


        while(!que.isEmpty()){
            int n = que.size();
            int sum = 0;
            while(n-- > 0) {
                TreeNode Node = que.poll();
                sum += Node.val;
                if(Node.left != null) {
                    que.add(Node.left);
                }
                if(Node.right != null){
                    que.add(Node.right);
                }
            }
            if (sum > maxsum) {
                minindex = currlvl;
                maxsum = sum;
            }
            currlvl++;
        }
        return minindex;
    }
    public int maxLevelSumdfs(TreeNode root) {
         list = new HashMap<>();

         dfs(root,1);
         int max_sum = Integer.MIN_VALUE;
         int resultlevel = 0;
         for(Map.Entry<Integer,Integer> entry : list.entrySet()){
             int level = entry.getKey();
             int sum = entry.getValue();

             if(sum > max_sum){
                 max_sum = sum;
                 resultlevel = level;
             }
         }
         return resultlevel;
    }
    public static void dfs(TreeNode node, int level){
        if(node == null){
            return;
        }
        list.put(level,list.getOrDefault(level,0)+node.val);
        if(node.left != null) dfs(node.left,level+1);
        if(node.right != null) dfs(node.right,level+1);
    }
}
