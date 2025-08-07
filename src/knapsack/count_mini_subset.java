package knapsack;

public class count_mini_subset {
    public static void main(String[] args) {
        int sum = 0;
        int[] arr = {1,1,1,1,1};
        int diff = 3;

        for(int i = 0 ; i < arr.length ; i++){
            sum = sum + arr[i];
        }

    
        if((diff + sum) % 2 != 0) {
            System.out.println("Count of subsets with a given difference: 0");
            return;
        }

        int s = (diff + sum)/2;
        System.out.println("Count of subsets with a given difference: " + count_subset(arr,s));
    }

    public static int count_subset(int[] arr, int s){
        int n = arr.length;
        int[][] t = new int[n+1][s+1];


        for(int i = 0; i <= n ; i++){
            t[i][0] = 1;
        }

        // Fill the DP table
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0; j <= s ; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][s];
    }
}
