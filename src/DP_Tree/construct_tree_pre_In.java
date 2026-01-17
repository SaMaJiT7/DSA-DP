package DP_Tree;

public class construct_tree_pre_In {
    static int idx = 0;
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode ans = buildTree(preorder,inorder);
        System.out.println(ans);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int p = preorder.length;
        int in = inorder.length;
        int idx = 0;

        return solve(preorder,inorder,0,p-1);
    }
    public static TreeNode solve(int[] preorder, int[] inorder,int start,int end){
        int in = inorder.length;
        if(start > end){
            return null;
        }

        int rootval = preorder[idx++];
        int i = start;
        while(inorder[i] != rootval) i++;
        TreeNode root = new TreeNode(rootval);
        root.left = solve(preorder,inorder,start,i-1);
        root.right = solve(preorder,inorder,i+1,end);

        return root;
    }
}
