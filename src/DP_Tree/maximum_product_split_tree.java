package DP_Tree;

public class maximum_product_split_tree {
    int mod = 1000000007;
    long maxp = 0;
    long Total_tree_sum = 0;

    public long totalsum(TreeNode root,long Totalsum) {
        if (root == null) return 0;
        long leftsum = totalsum(root.left,Totalsum);
        long rightsum = totalsum(root.right,Totalsum);
        long subtreesum = root.val + leftsum + rightsum;

        long Remainingsubtreesum = (Totalsum - subtreesum);
        long product = subtreesum * Remainingsubtreesum;

        // Now safe to access instance variable maxp
        maxp = Math.max(maxp, product);
        return subtreesum;
    }


    public int maxProduct(TreeNode root) {
        if (root == null) return 0;
        maxp = 0;
        Total_tree_sum = totalsum(root,Total_tree_sum);
        totalsum(root,Total_tree_sum);

        // Fixed: Parentheses are required to modulo BEFORE casting to int
        return (int) (maxp % mod);
    }
}
