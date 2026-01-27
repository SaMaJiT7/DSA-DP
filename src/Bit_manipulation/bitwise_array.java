package Bit_manipulation;

import java.util.List;

public class bitwise_array {
//    public int[] minBitwiseArray(List<Integer> nums) {
//        int n = nums.size();
//        int[] ans = new int[n];
//
//        for(int i = 0; i < n; i++){
//            boolean found = false;
//            for(int x = 0; x < nums.get(i); x++){
//                if((x | (x+1)) == nums.get(i)){
//                    ans[i] = x;
//                    found = true;
//                    break;
//                }
//            }
//            if(found == false){
//                ans[i] = -1;
//            }
//        }
//        return ans;
//    }
public int[] minBitwiseArray(List<Integer> nums) {
    int n = nums.size();
    int[] ans = new int[n];

    for(int i = 0; i < n; i++){
        int val = nums.get(i);

        if(val % 2 ==0){
            ans[i] = -1;
            continue;
        }
        for(int j = 0; j < 32; j++){

            if((val & (1 << j)) != 0){
                continue;
            }
            int x = val ^ (1<<(j-1));
            ans[i]= x;
            break;
        }
    }
    return ans;
}
}
