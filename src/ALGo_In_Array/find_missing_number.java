package ALGo_In_Array;

import static ALGo_In_Array.find_missing_number.swap;

public class find_missing_number {
    public static void main(String[] args) {
        int[] arr = {1,0,3,4};
        System.out.println(missingNum(arr));
    }
    static int missingNum(int[] arr){
        int i = 0;
        int end = arr.length - 1;
        while (i <= end) {
            if (arr[i] < arr.length && arr[i] != arr[arr[i]]) {
                swap(arr,i,arr[i]);
            }
            else {
                i++;
            }
        }
        for (int index = 0;index < arr.length ; index++){
            if(arr[index] != index){
                return index;
            }
        }
        return arr.length;
    }
    static void swap(int[] arr,int first,int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
