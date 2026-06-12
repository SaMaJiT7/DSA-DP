package DP_Tree;

public class sorted_array_to_BST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        return createTree(nums,start,end);
    }
    public TreeNode createTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums,0,mid-1);
        root.right = createTree(nums,mid+1,end);

        return root;
    }
}
