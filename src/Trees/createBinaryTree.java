package Trees;

import DP_Tree.TreeNode;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class createBinaryTree {
    public TreeNode createBinaryTree(int[][] descriptions) {
        int n  = descriptions.length;

        int root = 0;
        HashSet<Integer> childrens = new HashSet<>();
        for(int i = 0; i < n; i++){
            int c = descriptions[i][1];
            childrens.add(c);
        }
        for(int i = 0; i < n; i++){
            if(!childrens.contains(descriptions[i][0])){
                root = descriptions[i][0];
            }
        }
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int parent = descriptions[i][0];
            int child = descriptions[i][1];
            int isleft = descriptions[i][2];
            if(!map.containsKey(parent)) {
                map.put(parent, new TreeNode(parent));
            }
            if(!map.containsKey(child)){
                map.put(child, new TreeNode(child));
            }

            TreeNode parentNode = map.get(parent);
            TreeNode childNode = map.get(child);

            if(isleft == 1){
                parentNode.left = childNode;
            }
            else{
                parentNode.right = childNode;
            }
        }
        return map.get(root);
    }
}
