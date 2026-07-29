package DP_Tree;

import java.util.HashMap;

public class buildTree {
    static void main(String[] args) {

    }
    int inlen;
    int prelen;
    HashMap<Integer,Integer> map;
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inlen= inorder.length;
        this.prelen = preorder.length;
        this.map = new HashMap<>();
        for(int i = 0; i < inlen; i++){
            map.put(inorder[i],i);
        }

        return solve(preorder,0,inlen-1);
    }
    public TreeNode solve(int[] preorder,int start, int end){
        if(start > end) return null;

        int node = preorder[idx++];
        TreeNode root = new TreeNode(node);
        int pos = map.get(node);
        root.left = solve(preorder,start,pos-1);
        root.right = solve(preorder,pos+1,end);


        return root;
    }
}
