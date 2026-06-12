package graph;

import java.util.*;

public class jumps_min_graph {
    boolean[] isprime;
    void buildSeive(int maxEl) {
        this.isprime = new boolean[maxEl+1];
        Arrays.fill(isprime,true);
        isprime[0] = false;
        isprime[1] = false;
        for(int i = 2; i*i <= maxEl; i++){
            if(isprime[i]){
                for(int j = i*i; j <= maxEl; j += i){
                    isprime[j] = false;
                }
            }
        }
    }
    public int minJumps(int[] nums) {
        int n = nums.length;
        HashMap<Integer,List<Integer>> mp = new HashMap<>();
        int maxEl = 0;
        for(int i = 0; i < n; i++){
            mp.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i);
            maxEl = Math.max(maxEl,nums[i]);
        }

        buildSeive(maxEl);
        int steps = 0;
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visited[0] = true;
        HashSet<Integer> seen = new HashSet<>();

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-- > 0) {
                int idx = queue.poll();
                int num = nums[idx];

                if (idx == n - 1) {
                    return steps;
                }

                if (idx + 1 < n && !visited[idx + 1]) {
                    queue.add(idx + 1);
                    visited[idx + 1] = true;
                }

                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    queue.add(idx - 1);
                    visited[idx - 1] = true;
                }

                if (isprime[num] && !seen.contains(num)) {
                    for (int multiple = num; multiple <= maxEl; multiple += num) {
                        if (!mp.containsKey(multiple)) {
                            continue;
                        }

                        for (int j : mp.get(multiple)) {
                            if (!visited[j]) {
                                queue.add(j);
                                visited[j] = true;
                            }
                        }
                    }

                    seen.add(num);
                }
            }
            steps++;
        }
        return steps;
    }
}
