import java.util.Arrays;

public class RotationCount_rotatedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int count = rotationcount(arr);
        System.out.println(count);
    }
    static int rotationcount(int[] arr) {
        int pivot = findpivot(arr);
        return pivot + 1;
    }

    static int findpivot(int[] arr){
    int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(arr[mid] < arr[mid-1]){
                return mid-1;
            }
            if (arr[start] >= arr[mid]){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
    static int findpivotwithduplicate(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                if(arr[start] > arr[start + 1]){
                    return start;
                }
                start++;

                if(arr[end] < arr[end - 1]){
                    return end;
                }
                end--;
            }
            if(arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]){
                start= mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
