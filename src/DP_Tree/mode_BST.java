package DP_Tree;

import org.w3c.dom.xpath.XPathResult;

import java.util.ArrayList;
import java.util.List;

public class mode_BST {
    TreeNode prev = null;
    int maxcount = 0;
    int count = 0;
    List<Integer> result = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] arr = new int[result.size()];
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = result.get(i);
        }
        return arr;
    }
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(prev == null || root.val!=prev.val)count=1;
        else count++;
        if(count > maxcount){
            maxcount = count;
            result.clear();
            result.add(root.val);
        }
        else if(count == maxcount)result.add(root.val);
        prev = root;
        inorder(root.right);
    }
}
