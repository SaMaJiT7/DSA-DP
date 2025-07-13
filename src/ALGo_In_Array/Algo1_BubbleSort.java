package ALGo_In_Array;

import java.util.Arrays;

public class Algo1_BubbleSort {
    public static void main(String[] args) {
        int[] arr = {100,80,60,40,20,0};
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void BubbleSort(int[] arr){
        boolean swap;
        for (int i = 0; i < arr.length;i++){
            swap = false;
            for (int j = 1;j < arr.length - i;j++){

                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
    }

}
