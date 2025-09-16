package Sliding_Window;

public class maximum_sum {
    public static void main(String[] args) {

    }

    public static int max_sum(int[] arr , int k) {
        int currentsum = 0;
        int maxsum = 0;
        int n = arr.length;

        for(int i = 0; i < k ; i++){
            maxsum= maxsum+ arr[i];
        }
        currentsum = currentsum + maxsum;

        for (int i = k; i < n ; i++){
            currentsum = currentsum - arr[i-k]+arr[i];
            maxsum = Math.max(currentsum,maxsum);
        }
        return maxsum;
    }
}
