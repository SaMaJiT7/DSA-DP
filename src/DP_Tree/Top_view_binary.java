package DP_Tree;

import java.util.*;

public class Top_view_binary {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair i = queue.remove();
            int line = i.line;
            Node temp = i.node;

            if(map.get(line) == null){
                map.put(line,temp.data);
            }

            if(temp.left != null){
                queue.add(new Pair(temp.left,line-1));
            }

            if(temp.right != null){
                queue.add(new Pair(temp.right,line + 1));
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }

    class Pair{
        Node node;
        int line;

         Pair(Node x,int y){
            this.node = x;
            this.line = y;
        }
    }
}
