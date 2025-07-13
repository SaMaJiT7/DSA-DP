package ALGo_In_Array;

public class sorted {
    public static void main(String[] args) {
        int[] arr = {10,90,30,40,50};
        System.out.println(sort(arr,0));
    }
    public static boolean sort(int[] arr,int index){
        if (index == arr.length-1){
            return true;
        }
        return (arr[index] < arr[index+1]) && sort(arr,index+1);
    }
}
