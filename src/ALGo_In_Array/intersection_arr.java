package ALGo_In_Array;

import java.lang.invoke.DelegatingMethodHandle$Holder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class intersection_arr {
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        ArrayList<Integer> result = new ArrayList<>();
//        int i = 0;
//        int j = 0;
//        while(i < nums1.length && j < nums2.length){
//            if(nums1[i] == nums2[j]){
//                if (result.isEmpty() || result.get(result.size() - 1) != nums1[i]) {
//                    result.add(nums1[i]);
//                }
//                i++;
//                j++;
//            }
//            else if(nums1[i] < nums2[j]){
//                i++;
//            }
//            else{
//                j++;
//            }
//        }
//        return  result.stream().mapToInt(k -> k).toArray();
//    }
//
    public int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> unique = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int num : nums1){
            unique.add(num);
        }
        for(int num: nums2){
            if(unique.contains(num)){
                result.add(num);
            }
        }
        return  result.stream().mapToInt(i -> i).toArray();
    }

}
