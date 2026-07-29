package Leetcode_daily;

public class duplicate_zeros {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeroes = 0;
        for(int x : arr){
            if(x == 0) zeroes++;
        }
        int i = n-1;
        int j = n+zeroes-1;
        while(i != j){
            insert(arr,i,j--);
            if(arr[i] == 0){
                insert(arr,i,j--);
            }
            i--;
        }
    }
    private void insert(int[] arr, int i, int j){
        if(j < arr.length){
            arr[j] = arr[i];
        }
    }
}
