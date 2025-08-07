package Trees;

public class diameter_of_tree {
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
    public int diameterOfBinaryTree(TreeNode root) {
        TreeNode node = root;
        int res = Integer.MIN_VALUE;
        solve_dia(node,res);
        return res;

    }
    public int solve_dia(TreeNode node , int res){
        if(node == null){
            return 0;
        }

        int l = solve_dia(node.left,res);
        int r = solve_dia(node.right,res);

        int temp = 1 + Math.max(l,r);
        int ans = Math.max(temp,1+l+r);
        res = Math.max(res,ans);
        return temp;
    }
}
