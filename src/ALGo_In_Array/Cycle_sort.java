package ALGo_In_Array;

import java.util.Arrays;

public class Cycle_sort {
    public static void main(String[] args) {
        int[] arr ={0,3,1,2};
        cyclicsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclicsort(int[] arr) {
        int i = 0;
        int end = arr.length - 1;
        while (i <= end) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }
            else {
                i++;
            }
        }
    }
}