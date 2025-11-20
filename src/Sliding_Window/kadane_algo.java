package Sliding_Window;

public class kadane_algo {
    public static int Kadane(int[] arr){
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];

            if(sum > max){
                max = sum;
            }

            if(sum < 0){
                sum = 0;
            }

            if(max < 0){
                return 0;
            }
        }
        return max;
    }
}
