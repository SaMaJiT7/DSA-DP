public class CeilingOFaNumber {
    public static void main(String[] args) {
        int[] arr = {5,11,25,30,50,60,80,90,100};
        System.out.println(ceilingNumber(arr,75));
    }
    static int ceilingNumber(int[] arr, int target){

        if(target > arr[arr.length-1]){
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
////            else if (arr[Mid] > target){
////                return arr[Mid];
//            }
//            else {
//                return arr[Mid + 1];
//            }
        }
        return arr[start];
    }
}
