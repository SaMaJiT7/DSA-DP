package ALGo_In_Array;

import java.util.Arrays;

public class QUICKSORT {
    public static void main(String[] args) {
        int[] arr = {50,60,40,20,10,5,0};
        QS(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void QS(int[] arr,int low , int high){
        if(low >= high){
            return;
        }
        int s = low;
        int e = high;
        int m = s + (e-s)/2;
        int pivot = arr[m];

        while(s <= e){
            while (arr[s] < pivot){
                s++;
            }
            while (arr[e] > pivot){
                e--;
            }
            if(s <= e){
                int temp = arr[s]; 
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        QS(arr,low,e);
        QS(arr,s,high);
    }
}
