package Hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class find_the_difference {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> map = new HashSet<>();
        HashSet<Integer> map2 = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            ans.add(new ArrayList<>());
        }
        for(int i = 0; i < nums1.length; i++){
            map.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            map2.add(nums2[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            if(!map.contains(nums2[i]) && !ans.get(1).contains(nums2[i])){
                ans.get(1).add(nums2[i]);
            }
        }
        for(int i = 0; i < nums1.length; i++){
            if(!map2.contains(nums1[i]) && !ans.get(0).contains(nums1[i])){
                ans.get(0).add(nums2[i]);
            }
        }
        return ans;
    }
}
