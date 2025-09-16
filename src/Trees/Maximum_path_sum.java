package Trees;

public class Maximum_path_sum {
    public class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
     }
 }
    public int maxPathSum(TreeNode root) {
        TreeNode node1 = root;
        int[] sum = {Integer.MIN_VALUE};
        solve_maxi_path(node1, sum);
        return sum[0];

    }


    public int solve_maxi_path(TreeNode node , int[] sum){
        if(node == null){
            return 0;
        }

        int l = Math.max(0,solve_maxi_path(node.left,sum));
        int r = Math.max(0,solve_maxi_path(node.right,sum));


        sum[0] = Math.max(sum[0],l+r+node.val);
        return Math.max(node.val + Math.max(l,r),node.val);
    }
}
