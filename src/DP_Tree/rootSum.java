package DP_Tree;

public class rootSum {
    int sum = 0;
//    public int sumRootToLeaf(TreeNode root) {
//        dfs(root,new StringBuilder());
//        return sum;
//    }
//    public void dfs(TreeNode root, StringBuilder ans){
//        if(root == null) return;
//
//        ans.append(root.val);
//
//        if(root.left == null && root.right == null){
//            sum += Integer.parseInt(ans.toString(),2);
//        }
//        else{
//            dfs(root.left,ans);
//            dfs(root.right,ans);
//        }
//        ans.deleteCharAt(ans.length()-1);
//    }
    public int sumRootToLeaf(TreeNode root) {
       return dfs(root,0);
    }
    public int dfs(TreeNode root, int val){
        if(root == null) return 0;

        val = (2*val) + root.val;

        if(root.left == null && root.right == null) return val;

        return dfs(root.left,val) + dfs(root.right,val);
    }

}
