package DP_Tree;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Stack;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
public class boundary_tranversal {
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(isLeaf(root) == false){
            ans.add(root.data);
        }
        addLeftBoundary(root,ans);
        addLeaves(root,ans);
        addRightBoundary(root,ans);
        return ans;
    }
    public boolean isLeaf(Node node){
        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }
    void addLeftBoundary(Node root,ArrayList<Integer> res){
        Node curr = root.left;
        while(curr != null){
            if(isLeaf(curr) == false){
                res.add(curr.data);
            }
            if(curr.left != null){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
    }

    void addRightBoundary(Node root,ArrayList<Integer> res){
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(isLeaf(curr) == false){
                temp.add(curr.data);
            }
            if(curr.right != null){
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }

        for(int i = temp.size()-1; i >= 0; i--){
            res.add(temp.get(i));
        }
    }

    void addLeaves(Node root,ArrayList<Integer> res){
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left != null) addLeaves(root.left,res);
        if(root.right != null) addLeaves(root.right,res);

    }
}
