package graph;

import java.util.*;

public class minJumps {
    static final int max = 1000001;
    static int[] spf = new int[max];

//    static {
//        for(int i = 0; i < max; i++){
//            spf[i] = i;
//        }
//
//        for(int i = 2; i*i < max; i++){
//            if(spf[i] == i){
//                for(int j = i*i; j < max; j += i){
//                    if(spf[j] == j){
//                        spf[j] = i;
//                    }
//                }
//            }
//        }
//        spf[0] = 0;
//        spf[1] = 0;
//    }
//    public List<Integer> getPrimefactors(int num){
//        List<Integer> primeFactors = new ArrayList<>();
//
//        while(num > 1){
//            int val = spf[num];
//            primeFactors.add(val);
//
//            while(num % val == 0){
//                num = num / val;
//            }
//        }
//        return primeFactors;
//    }
//    public int minJumps(int[] nums) {
//        int n = nums.length;
//        HashMap<Integer,List<Integer>> edges = new HashMap<>();
//        for(int i = 0; i < n; i++){
//            for(int p : getPrimefactors(nums[i])){
//                edges.computeIfAbsent(p,k -> new ArrayList<>()).add(i);
//            }
//        }
//        int steps = 0;
//        boolean[] visited = new boolean[n];
//
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(0);
//        visited[0] = true;
//        List<Integer> seen = new ArrayList<>();
//
//        while(!queue.isEmpty()){
//            int size = queue.size();
//
//            while(size-- > 0){
//               int idx = queue.poll();
//               int num = nums[idx];
//
//               if(idx == n-1){
//                   return steps;
//               }
//
//               if(idx+1 < n && !visited[idx+1]){
//                   queue.add(idx+1);
//                   visited[idx+1] = true;
//               }
//
//               if(idx-1 >= 0 && !visited[idx-1]){
//                   queue.add(idx-1);
//                    visited[idx-1] = true;
//               }
//
//
//
//               if(num > 1 && spf[num] == num){
//                   for(int node : edges.get(num)){
//                       if(!visited[node]){
//                           queue.add(node);
//                           visited[node] = true;
//                       }
//                   }
//                   edges.get(num).clear();
//               }
//           }
//           steps++;
//
//        }
//
//        return -1;
//    }

}
