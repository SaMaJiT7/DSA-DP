package DP_Tree;

import java.util.*;

public class find_leaves_Binary_tree {

    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> findleaves(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        height(root);

        // Convert map to result list in order of height
        int maxHeight = Collections.max(map.keySet());
        for (int i = 0; i <= maxHeight; i++) {
            result.add(map.get(i));
        }

        return result;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return -1; // leaf will get height 0
        }

        int LH = height(root.left);
        int RH = height(root.right);

        int H = 1 + Math.max(LH, RH);

        // store nodes by height
        map.computeIfAbsent(H, k -> new ArrayList<>()).add(root.val);

        return H;
    }
}

