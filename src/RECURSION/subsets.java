package RECURSION;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        subhelper(nums,subset,new ArrayList (),0);
        return subset;
    }

    static void subhelper(int[] nums,List<List<Integer>> subsets ,List<Integer> ans,int index){
        subsets.add(new ArrayList (ans));
        for(int i = index ; i < nums.length;i++){
            ans.add(nums[index]);
            subhelper(nums,subsets,ans,i+1);
            ans.remove(ans.size()-1);
        }
    }


}
