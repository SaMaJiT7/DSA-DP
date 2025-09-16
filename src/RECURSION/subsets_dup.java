package RECURSION;

import java.util.ArrayList;
import java.util.List;

public class subsets_dup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        subhelper(nums,subset,ans,0);
        return subset;
    }

    static void subhelper(int[] nums,List<List<Integer>> subsets ,List<Integer> ans,int index){
       if(!subsets.contains(ans)){
           subsets.add(new ArrayList<>(ans));
       }
        for(int i = index ; i < nums.length;i++){
            ans.add(nums[i]);
            subhelper(nums,subsets,ans,i+1);
            ans.remove(ans.size()-1);
        }
    }
}
