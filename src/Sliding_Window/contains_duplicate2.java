package Sliding_Window;

import java.util.HashSet;

public class contains_duplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        HashSet<Integer> unique = new HashSet<>();
        while(j < n){
            int incoming = nums[j];
            if(unique.contains(incoming)){
                return true;
            }
            else{
                unique.add(incoming);
            }

           while(j-i+1 > k) {
               if (unique.contains(nums[i])) {
                   unique.remove(nums[i]);
               }
               i++;
           }
           j++;
        }
        return false;
    }
}
