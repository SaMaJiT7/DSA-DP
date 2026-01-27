package DP_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class return_forest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < to_delete.length; i++){
            map.put(to_delete[i],map.getOrDefault(to_delete[i],0)+1);
        }
        dfs(root,map,ans);
        if(!map.containsKey(root.val)){
            ans.add(root);
        }
        return ans;
    }
    public TreeNode dfs(TreeNode root, HashMap<Integer,Integer> map,List<TreeNode> result){
        if(root == null){
            return null;
        }
        root.left = dfs(root.left,map,result);
        root.right = dfs(root.right,map,result);

        if(map.containsKey(root.val)){
            if(root.left != null) result.add(root.left);
            if(root.right != null) result.add(root.right);

            return null;
        }
        else{
            return root;
        }
    }
}
