package LC_QUestion;

import java.util.HashSet;

public class absent_int {
    public int smallestAbsent(int[] nums) {

        int n = nums.length;
        if(n == 0){
            return 1;
        }
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
        }
        double avg =  (double) sum / n;

        int x = (int) (Math.floor(avg) + 1);
        if (x < 1) {
            x = 1;  // Ensure positive
        }

        HashSet<Integer> map = new HashSet<>();
        for(int  i : nums){
            map.add(i);
        }

        while(true){
            if(!map.contains(x)){
                return x;
            }
            x++;
        }
}
}
