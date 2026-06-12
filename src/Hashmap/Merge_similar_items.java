package Hashmap;

import java.util.*;

public class Merge_similar_items {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,Integer> unique = new HashMap<>();
        for(int[] item : items1){
            unique.put(item[0],item[0]);
        }
        for(int[] item : items2){
            unique.put(item[0],unique.getOrDefault(item[0],0)+item[1]);
        }
        for(int key : unique.keySet()){
            ans.add(Arrays.asList(key,unique.get(key)));
        }
        ans.sort((a,b) ->  a.get(0) - b.get(0));
        return ans;
    }
}
