package LC_QUestion;

public class minimumcost_to_divide_arra {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return 0;
        }
        else if(n == 3){
            return (nums[0]+nums[1]+nums[2]);
        }
        int e1 = nums[0];
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++){
            if(nums[i] < first){
                second = first;
                first = nums[i];
            }
            else if(nums[i] < second){
                second = nums[i];
            }
        }
        return e1+first+second;
    }
}
