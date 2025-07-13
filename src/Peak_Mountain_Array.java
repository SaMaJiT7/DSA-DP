public class Peak_Mountain_Array {
    public static void main(String[] args) {
    }

    int search(int[] mountainArr, int target) {
        int peakelement = peak(mountainArr);
        int Firsttry = binarysearch(mountainArr,target,0,peakelement);
        if (Firsttry != -1){
            return Firsttry;
        }
        else {
            return binarysearch(mountainArr,target,peakelement+1,mountainArr.length-1);
        }
    }

    static int peak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid - 1]) {
                end = mid;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            }
        }
        return start;
    }

    static int binarysearch(int[] arrs, int target, int start, int end) {
        while (start < end) {

            int Mid = start + (end - start) / 2;
            if (arrs[Mid] > target) {
                end = Mid - 1;
            } else if (arrs[Mid] < target) {
                start = Mid + 1;
            } else {
                return Mid;
            }
        }
        return -1;
    }
}
