package DP_Tree;

import java.util.*;

public class zig_zag_traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        boolean leftToRight = true;

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            List<Integer> res = new ArrayList<>(Collections.nCopies(size, 0));

            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                int index = leftToRight ? i : (size - 1 - i);
                res.set(index, node.val);

                if (node.left != null) nodeQueue.add(node.left);
                if (node.right != null) nodeQueue.add(node.right);
            }

            ans.add(res);
            leftToRight = !leftToRight;
        }

        return ans;
    }

}
