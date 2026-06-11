package Leetcode_daily;

import java.util.Arrays;



public class contest {
//    public boolean consecutiveSetBits(int n) {
//        int setbit = 0;
//        int x = n;
//        while(x != 0){
//            if((x & 1) != 0){
//                setbit += 1;
//                if(setbit >= 2){
//                    return true;
//                }
//            }
//            else{
//                setbit = 0;
//            }
//            x = x >> 1;
//        }
//        return false;
//    }
public long maxTotal(int[] nums, String s) {
    int n = nums.length;
    boolean[] canMove = new boolean[n];
    char[] arr = s.toCharArray();
    Arrays.fill(canMove,true);
    for(int i = 1; i < n; i++){
        char token = arr[i];
        if(token == '0'){
            continue;
        }
        else if(canMove[i]){
            if(nums[i-1] > nums[i]){
                swap(arr,i-1,i);
                canMove[i-1] = false;
            }
        }
    }
    int maxtotal = 0;
    for(int i = 0; i < n; i++){
        if(arr[i] == '1'){
            maxtotal += nums[i];
        }
    }
    return maxtotal;
}
public void swap(char[] arr, int a, int b){
    char temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}
}
