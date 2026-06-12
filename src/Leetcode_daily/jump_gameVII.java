package Leetcode_daily;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class jump_gameVII {
//    boolean[] canjump;
//    public boolean canReach(String s, int minJump, int maxJump) {
//        int n = s.length();
//        this.canjump = new boolean[n];
//        Arrays.fill(canjump,false);
//        canjump[0] = true;
//        int furtherProcessed = 0;
//        for(int i = 0; i < n; i++){
//            if(s.charAt(i) == '0' && canjump[i]){
//                int start = Math.max(furtherProcessed+1,i + minJump);
//                int end = Math.min(i + maxJump,n-1);
//                for(int j = start; j <= end; j++){
//                    if(s.charAt(j) == '0'){
//                        canjump[j] = true;
//                    }
//                }
//                furtherProcessed = end;
//            }
//        }
//        return canjump[n-1];
//    }
public boolean canReach(String s, int minJump, int maxJump) {
    Queue<Integer> queue = new LinkedList<>();
    int n = s.length();
    boolean[] visited = new boolean[n];
    queue.add(0);
    visited[0] = true;
    int furtherProcessed = 0;
    while(!queue.isEmpty()){
        int idx = queue.poll();
        if(s.charAt(idx) == '0') {
            int start = Math.max(furtherProcessed + 1, idx + minJump);
            int end = Math.min(n - 1, idx + maxJump);
            for(int j = start; j <= end; j++){
                if(s.charAt(j) == '0' && !visited[j]){
                    visited[j] = true;
                    queue.add(j);
                }
            }
            furtherProcessed = end;
        }
    }
    return visited[n-1];
}
}
