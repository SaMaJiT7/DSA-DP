package Leetcode_daily;

public class rotate {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reversenums(nums,0,n-1);
        reversenums(nums,0,k-1);
        reversenums(nums,k,n-1);
    }
    public void reversenums(int[] arr , int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
