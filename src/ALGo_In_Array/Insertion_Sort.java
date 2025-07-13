package ALGo_In_Array;

import java.util.Arrays;

public class Insertion_Sort {
    public static void main(String[] args) {
        int[] arr = {5,3,4,1,2};
        insertionsort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertionsort(int[] arr){
        for (int i = 0; i < arr.length - 1 ; i++) {
            for (int j = i+1; j > 0; j--) {
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
                else {
                    break;
                }
            }
        }
    }
}
