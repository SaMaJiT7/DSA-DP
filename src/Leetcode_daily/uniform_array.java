package Leetcode_daily;

public class uniform_array {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int odd = 0;
        int even = 0;
        for(int i = 0; i < n; i++){
            if(nums1[i] % 2 == 0) even++;
            else odd++;
        }
        //EVEN
        boolean iseven = true;
        for(int i = 0; i < n; i++){
            if(nums1[i] % 2 == 0){
                continue;
            }
            else{
                if(odd >= 2){
                    continue;
                }
                else{
                    iseven = false;
                }
            }
        }

        //ODD
        boolean isodd = true;
        for(int i = 0; i < n; i++){
            if(nums1[i] % 2 != 0){
                continue;
            }
            else{
                if(odd >= 1 && even >= 1){
                    continue;
                }
                else{
                    isodd = false;
                }
            }
        }

        return iseven | isodd;
    }
}
