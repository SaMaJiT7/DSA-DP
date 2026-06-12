package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class same_leaf_nodes {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = getLeafNode(root1);
        List<Integer> tree2 = getLeafNode(root2);

        if(tree1.size() != tree2.size()) return false;

        return tree1.equals(tree2);
    }
    public List<Integer> getLeafNode(TreeNode root){
        if(root == null) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        if(root.left == null && root.right == null){
            ans.add(root.val);
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        if(root.left != null)  left = getLeafNode(root.left);
        if(root.right != null) right = getLeafNode(root.right);

        ans.addAll(left);
        ans.addAll(right);
        return ans;
    }
}
