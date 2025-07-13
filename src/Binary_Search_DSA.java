public class Binary_Search_DSA {
    public static void main(String[] args) {
        int[] arr = {5,11,25,30,50,60,80,90,100};
        System.out.println(index(arr,99));
    }
    //Return the index
    static int index(int[] arr, int target){
        int start = 0;
        int End = arr.length - 1;


        while(start <= End ){
            // Find the middle element
            int M = start + (End - start)/ 2;    //M = Middle Element.
            if(arr[M] < target){
                start = M + 1;
                System.out.println("The New Index of the start is: "+start);
            }
            else if(arr[M] > target){
                End = M - 1;
                System.out.println(End);
            }
            else {
                return M;
            }
        }
        return -1;
    }
}
