import java.util.Arrays;

public class First_last_occurrence {
    public static void main(String[] args) {
        int[] arr = {2,8,10,10,10,12,14};
        int res = first(arr,10);
    //    System.out.println(res);
        int las = last(arr,10);
    //    System.out.println(las);
        count(arr,10,res,las);
    }

    static void count(int[] arr,int target,int res,int las){
        int start = res;
        int end = las;

        int Count = (end - start) + 1;
        System.out.printf("The Number of count: %d",Count);
    }
    static int first(int[] arr,int target) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;
        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                res = mid;
                end = mid - 1;

            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
        static int last(int[] arr,int target){
            int start = 0;
            int end = arr.length - 1;
            int las = -1;
            while(start <= end){

                int mid = start + (end - start)/2;

                if(arr[mid] == target){
                    las = mid;
                    start = mid + 1;

                }
                else if(arr[mid] > target){
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            return las;
    }
}
