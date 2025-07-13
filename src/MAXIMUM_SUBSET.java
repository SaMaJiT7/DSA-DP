import java.util.Scanner;

public class MAXIMUM_SUBSET {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of Array:  ");
        int n = sc.nextInt(); // size of array
        int[] arr = new int[n];

        System.out.println("Enter the value of the Array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // reading array elements
        }

        int sum = sc.nextInt(); // target sum

        int[][] t = new int[n+1][sum+1];

        // Initialization
        for(int i = 0; i <= n; i++) {
            t[i][0] = 1; // There is 1 subset (empty subset) for sum = 0
        }

        // Filling DP table
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= sum; j++) {
                if(arr[i-1] <= j) {
                    t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        System.out.println("Number of subsets with sum " + sum + " = " + t[n][sum]);
    }
}
