package ALGo_In_Array;

public class BS_Recursion {
    public static void main(String[] args) {
        int [] arr = {10,20,30,50,60,80};
        System.out.println(search(arr,50,0, arr.length-1));
    }

    static int search(int[] arr, int target, int s, int e) {

        if (s > e) {
            return -1;
        }
        int mid = s + (e - s) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target > arr[mid]) {
                return search(arr, target, s = mid + 1, e);
            }
            return search(arr, target, s, e = mid - 1);
    }
}