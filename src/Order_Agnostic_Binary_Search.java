public class Order_Agnostic_Binary_Search {
    public static void main(String[] args) {
        int[] arr = {90,82,77,72,60,50,20,15,9};
        orderagnosticbs(arr , 72);
    }
    static int orderagnosticbs(int[] arr,int target){
        int start = 0;
        int End = arr.length - 1;

        boolean isAsc = arr[start] < arr[End];

        while (start <= End) {
            // Find the middle element
            int M = start + (End - start) / 2; //M = Middle Element.

            if(arr[M] == target){
                return M;
            }

            if(isAsc){
                if(arr[M] < target){
                    start = M + 1;
                    System.out.println("The New Index of the start is: "+start);
                }
                else {
                    End = M - 1;
                    System.out.println(End);
                }

            }
            if (arr[M] < target) {
                End = M - 1;
                System.out.println("The New Index of the End is: " + End);
            } else  {
                start = M + 1;
                System.out.println("The New Index of the Start is: " +start);
            }
        }
        return -1;
    }
}
