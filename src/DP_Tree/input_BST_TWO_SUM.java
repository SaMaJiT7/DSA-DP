package DP_Tree;

import java.util.ArrayList;
import java.util.List;

public class input_BST_TWO_SUM {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inorder(root,arr);
        int i = 0;
        int j = arr.size()-1;
        while(i < j){
            int sum = arr.get(i)+arr.get(j);
            if(sum == k) return true;
            else if (sum < k) {
                i++;
            }
            else{
                j--;
            }
        }
        return false;
    }
    public void inorder(TreeNode root,List<Integer> ans){
        if(root == null){
            return;
        }
        inorder(root.left,ans);

        ans.add(root.val);

        inorder(root.right,ans);
    }
}
