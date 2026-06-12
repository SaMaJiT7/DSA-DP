package Leetcode_daily;

public class Max_rotate_function {
//    public int maxRotateFunction(int[] nums) {
//        int n = nums.length;
//        int[] newarr = new int[2*n];
//        int newn = newarr.length;
//        for(int i = 0; i < n; i++){
//            newarr[i] = nums[i];
//        }
//        for(int i = n; i < newarr.length; i++){
//            newarr[i] = nums[i-n];
//        }
//        long weightedsum = 0;
//        long sum = 0;
//        for(int i = 0; i < n; i++){
//            weightedsum += ((long) i * nums[i]);
//            sum += nums[i];
//        }
//
//        int i = 0;
//        int j = n;
//        long max = weightedsum;
//        while(i < n && j < newn){
//            if(j-i < n){
//                sum += newarr[j];
//                weightedsum += (long)(j - i) * newarr[j];
//                j++;
//            }
//
//            else if(j-i == n){
//                max = Math.max(max,weightedsum);
//                weightedsum = weightedsum - (sum - newarr[i]);
//                sum -= newarr[i];
//                i++;
//            }
//        }
//        return (int) max;
//    }
public int maxRotateFunction(int[] nums) {
    int n = nums.length;
    int sum = 0;
    long weightedsum =0;
    for(int i = 0; i < n; i++){
        sum += nums[i];
        weightedsum += (long)i * nums[i];
    }
    long result = weightedsum;
    for(int k = 0; k < n; k++){
       long newweighted = weightedsum + sum - (long) n * nums[n-1-k];
       result = Math.max(result,newweighted);
       weightedsum = newweighted;
    }
    return (int) result;
}
}
