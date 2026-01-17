package binary_search;

public class Minimum_difference_sorted_array
{
    public int min_diff(int[] arr,int key){
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] == key){
                return arr[mid];
            }
            else if(arr[mid] < key){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        int a = Math.abs(arr[start] - key);
        int b = Math.abs(arr[end]-key);
        return a > b ? b : a;
    }
}
