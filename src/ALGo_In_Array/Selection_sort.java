package ALGo_In_Array;

import java.util.Arrays;

public class Selection_sort {
    public static void main(String[] args) {
        int[] arr = {2,-45,60,0,34,-77};
        selectionsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionsort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int last = arr.length - i - 1;
            //Find the Maximum element
            int maxindex = getmax(arr,0,last);
            swap(arr,maxindex,last);

        }
    }


    static void swap(int[] arr, int first , int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }


    static int getmax(int[] arr, int start, int end) {
        int max = start;
        for (int i = 0; i <= end; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }
}
