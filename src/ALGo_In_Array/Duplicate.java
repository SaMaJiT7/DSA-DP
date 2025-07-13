package ALGo_In_Array;

import java.util.Arrays;

public class Duplicate {
    public static void main(String[] args) {
        int[] arr = {1,4,3,5,4};
        duplicateno(arr);
        Arrays.toString(arr);
    }
    static int[] duplicateno(int[] arr){
        int i = 0;
        int n = arr.length-1;
        while(i <= n){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }
            else{
                i++;
            }
        }
        for(int index = 0; index < arr.length;index++){
            if(arr[index] != index +1){
                return new int[]{index,arr[index]};
            }
        }
        return new int[] {-1,-1};
    }
}
