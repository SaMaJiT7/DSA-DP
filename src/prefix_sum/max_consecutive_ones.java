package prefix_sum;

public class max_consecutive_ones {
//    public int longestOnes(int[] nums, int k) {
//        int n = nums.length;
//
//        int i = 0;
//        int j = 0;
//        int xerocount = 0;
//        int result = Integer.MIN_VALUE;
//        while(j < n){
//            if(nums[j] == 0){
//                xerocount++;
//            }
//            if(xerocount <= k){
//                result = Math.max(result,j-i+1);
//            }else{
//                if(nums[i] == 0){
//                    xerocount--;
//                }
//                i++;
//            }
//            j++;
//        }
//        return result;
//    }

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int currentOnes = prefix[j] - (i > 0 ? prefix[i - 1] : 0);
                int currentLength = j - i + 1;
                int currentZeros = currentLength - currentOnes;
                if (currentZeros<= k) {
                    result = Math.max(result, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return result;
    }
}
