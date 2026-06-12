package Leetcode_daily;

import java.util.*;

public class JUMP_GAME_HARD {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> paths = new HashMap<>();
        int n = arr.length;
        for(int i = 0; i < n; i++){
            paths.computeIfAbsent(arr[i],k -> new ArrayList<>()).add(i);
        }
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];
        que.add(0);
        visited[0] = true;

        int ans = 0;
        while(!que.isEmpty()){
            int size = que.size();
            for(int check = 0; check < size; check++) {
                int i = que.poll();
                if(i == n-1) return ans;
                if (i - 1 >= 0 && !visited[i - 1]) {
                    que.add(i - 1);
                    visited[i - 1] = true;
                }
                if (i + 1 < n && !visited[i + 1]) {
                    que.add(i + 1);
                    visited[i + 1] = true;
                }
                if (paths.containsKey(arr[i])) {
                    for (int next : paths.get(arr[i])) {
                        if (!visited[next]) {
                            que.add(next);
                            visited[next] = true;
                        }
                    }
                    paths.remove(arr[i]);
                }
            }
            ans++;
        }
        return -1;
    }
}
