package ALGo_In_Array;

public class Duplicate_number {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(duplicate(arr));
    }
    static int duplicate(int[] arr){
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
        for (int index = 0;index < arr.length ; index++){
            if(arr[index] != index+1){
                return arr[index];
            }
        }
        return -1;
    }
}
