public class Floor_OfNumber {
    public static void main(String[] args) {
        int[] arr = {5,11,25,30,50,60,80,90,100};
        System.out.println(FloorNumber(arr,4));
    }
    static int FloorNumber(int[] arr, int target){

        if(arr[0] > target){
            return -1;
        }


        int start = 0;
        int end = arr.length - 1;


        while(start <= end){
            int Mid = start + (end - start)/2;
            if(arr[Mid] == target){
                return target;
            }
            else if(arr[Mid] < target){
                start = Mid + 1;
            }
            else if(arr[Mid] > target){
                end = Mid - 1;
            }
        }
        return arr[end];
    }
}
