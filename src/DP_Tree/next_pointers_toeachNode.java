package DP_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class next_pointers_toeachNode {

    public Node connect(Node root) {
        if(root == null) return root;
        bfs(root);
        return root;
    }
    public void bfs(Node root){
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; i++){
                Node curr = que.poll();
                if(i < size-1){
                    curr.next = que.peek();
                }

                if(curr.left!=null) que.add(curr.left);
                if(curr.right!=null) que.add(curr.right);
            }
        }
    }
}
