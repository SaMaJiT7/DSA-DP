package prefix_sum;
import java.util.*;
public class GregAndArray {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Read input
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            // Read initial array (1-indexed for convenience)
            long[] a = new long[n + 1];
            for(int i = 1; i <= n; i++) {
                a[i] = sc.nextLong();
            }

            // Store operations
            int[][] operations = new int[m + 1][3];
            for(int i = 1; i <= m; i++) {
                operations[i][0] = sc.nextInt(); // l
                operations[i][1] = sc.nextInt(); // r
                operations[i][2] = sc.nextInt(); // d
            }


            long[] opCount = countOperationFrequencies(m, k, sc);


            applyOperationsToArray(a, operations, opCount, n, m);

            // Output result
            for(int i = 1; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
        }

        // Phase 1: Count operation frequencies using difference array technique
        private static long[] countOperationFrequencies(int m, int k, Scanner sc) {
            long[] opCount = new long[m + 1];

            // Process all k queries using difference array technique
            for(int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                // Mark the range [x, y] - increment at start, decrement after end
                opCount[x]++;
                if(y + 1 <= m) {
                    opCount[y + 1]--;
                }
            }

            // Convert difference array to actual frequencies using prefix sum
            for(int i = 1; i <= m; i++) {
                opCount[i] += opCount[i - 1];
            }

            return opCount;
        }

        // Phase 2: Apply operations to array using difference array technique
        private static void applyOperationsToArray(long[] a, int[][] operations,
                                                   long[] opCount, int n, int m) {
            long[] diff = new long[n + 1]; // difference array for the main array

            // Apply each operation opCount[i] times
            for(int i = 1; i <= m; i++) {
                int l = operations[i][0];
                int r = operations[i][1];
                int d = operations[i][2];

                // Calculate total effect of this operation
                long totalEffect = (long) d * opCount[i];

                // Apply range update [l, r] using difference array
                diff[l] += totalEffect;
                if(r + 1 <= n) {
                    diff[r + 1] -= totalEffect;
                }
            }

            // Convert difference array to actual increments and add to original array
            for(int i = 1; i <= n; i++) {
                diff[i] += diff[i - 1];  // prefix sum to get actual increment
                a[i] += diff[i];         // add to original array
            }
        }
}
