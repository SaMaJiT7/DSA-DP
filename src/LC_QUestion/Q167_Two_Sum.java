package LC_QUestion;

import java.util.Arrays;

public class Q167_Two_Sum {
    public static void main(String[] args) {
        int[] arr = {10,13,30,40};
        int target = 23;
        System.out.println(Arrays.toString(twosum(arr,target)));
    }
    static int[] twosum(int[] arr ,int target){
        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid] < target){
                if(arr[mid] + arr[mid+1] == target){
                    return new int[]{mid,mid+1};
                }
                else {
                    return new int[]{mid,mid-1};
                }
            }

        }
        return new int[]{-1,-1};
    }
}
