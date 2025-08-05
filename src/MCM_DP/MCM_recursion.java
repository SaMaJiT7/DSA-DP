package MCM_DP;

public class MCM_recursion {
    public static void main(String[] args) {
        int[] arr = {10,20,30,10,30};
        int i = 1;
        int j = arr.length-1;
        System.out.println(solve_MCM(arr,i,j));
    }

    public static int solve_MCM(int[] arr , int i , int j){
        if(i >= j){
            return 0;
        }
        int max = Integer.MIN_VALUE;

        for(int k = i+1; k <= j ; k++){
            int temp = (solve_MCM(arr,i,k-1) + solve_MCM(arr,k,j)+ (arr[i-1]*arr[k]*arr[j]));

            if(temp > max){
                max = temp;
            }

        }
        return max;
    }
}
