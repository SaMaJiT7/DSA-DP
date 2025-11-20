package DP_Tree;

public class diameter_tree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = {0};
        solve_dia(root, res);
        return res[0];
    }

    public int solve_dia(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }

        int left = solve_dia(node.left, res);
        int right = solve_dia(node.right, res);


        res[0] = Math.max(res[0], left + right);


        return 1 + Math.max(left, right);
    }
}
