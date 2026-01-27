package LC_QUestion;

import java.util.ArrayList;

public class minimum_pair {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int operations = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            list.add(i,nums[i]);
        }
        if(isNonDecreasing(list)){
            return 0;
        }
        while(!isNonDecreasing(list)) {
                int minsum = Integer.MAX_VALUE;
                int minindex = 0;
                for (int i = 0; i < list.size() - 1; i++) {
                    int sum = list.get(i) + list.get(i + 1);
                    if (sum < minsum) {
                        minindex = i;
                        minsum = sum;
                    }
                }
                list.remove(minindex);
                list.remove(minindex);
                list.add(minindex, minsum);
                operations++;
            }
        return operations;
    }
    public boolean isNonDecreasing(ArrayList<Integer> list){
        if(list.size() <= 1) return true;
        for(int i = 1; i < list.size(); i++){
            if(list.get(i-1) > list.get(i)){
                return false;
            }
        }
        return true;
    }
}
