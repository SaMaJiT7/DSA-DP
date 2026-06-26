package DP_Tree;

public class Maximum_Binary_tree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        return solve(0,n-1,nums,n);
    }
    public TreeNode solve(int start, int end,int[] nums,int n){
        if(start > end){
            return null;
        }
        int max = nums[start];
        int idx = start;
        for(int i = start; i <= end; i++){
            if(max < nums[i]){
                max = nums[i];
                idx = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = solve(start,idx-1,nums,n);
        node.right = solve(idx+1,end,nums,n);

        return node;
    }
}
