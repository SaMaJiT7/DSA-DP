public class Descending_Binary_Search {
    public static void main(String[] args) {
        int[] arr = {90,82,77,72,60,50,20,15,9};
        System.out.println(index(arr,15));
    }

    static int index(int[] arr, int target) {
        int start = 0;
        int End = arr.length - 1;


        while (start <= End) {
            // Find the middle element
            int M = start + (End - start) / 2;    //M = Middle Element.
            if (arr[M] < target) {
                End = M - 1;
                System.out.println("The New Index of the End is: " + End);
            } else if (arr[M] > target) {
                start = M + 1;
                System.out.println("The New Index of the Start is: " +start);
            }
            else {
                return M;
            }
        }
        return -1;
    }
}
