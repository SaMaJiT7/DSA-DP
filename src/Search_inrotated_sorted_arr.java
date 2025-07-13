public class Search_inrotated_sorted_arr {
    public static void main(String[] args) {

    }

    static int binarysearch(int[] arr, int target) {
        int pivot = findpivot(arr);

        if (pivot == -1) {
            return Binarysearch(arr,target,0,arr.length-1);
        }
        if (target >= arr[0]){
            return Binarysearch(arr,target,0,pivot-1);
        }
        else {
            return Binarysearch(arr,target,pivot+1,arr.length-1);
        }
    }
    static int Binarysearch(int[] arr, int target,int start ,int end) {
    while(start<end){
        int Mid = start + (end - start) / 2;
        if (arr[Mid] > target) {
            end = Mid - 1;
        } else if (arr[Mid] < target) {
            start = Mid + 1;
        } else {
            return Mid;
        }
    }
       return-1;
}

    static int findpivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(mid < end && arr[mid] > arr[mid+1]){
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
}
