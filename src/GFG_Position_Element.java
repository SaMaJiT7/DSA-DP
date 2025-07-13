public class GFG_Position_Element {
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170,300,400,500,700};
        int Answer = ans(arr,90);
        System.out.println(Answer);
    }

    static  int ans(int[] arrs , int target){
        int start = 0;
        int end = 1;


        while(target > arrs[end]) {
            int newstart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newstart;
        }
        return binarysearch(arrs,target,start,end);
    }
    static int binarysearch(int[] arrs , int target, int start , int end){
        while (start < end){

            int Mid = start + (end - start)/2;
            if(arrs[Mid] > target){
                end = Mid - 1;
            }
            else if(arrs[Mid] < target){
                start = Mid + 1;
            }
            else {
                return Mid;
            }
        }
        return -1;
    }
}
