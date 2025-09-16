package Greedy;

import java.util.Arrays;
import java.util.TreeSet;

public class job_sequence {
    public int[] JobScheduling(int[][] Jobs) {
        int n = Jobs.length;
        int totalprofit = 0;
        int totaljobs = 0;
        int maxdeadline = 0;
        int col = 2;
        Arrays.sort(Jobs,(row1, row2) -> Integer.compare(row2[col], row1[col]));

        for(int i = 0; i < n; i++){
            maxdeadline = Math.max(maxdeadline,Jobs[i][1]);
        }
        // Use TreeSet for available slots (descending order for latest first, but floor handles it)
        TreeSet<Integer> availableSlots = new TreeSet<>();
        for (int d = maxdeadline; d >= 1; d--) {  // Add from max to 1 for natural ordering
            availableSlots.add(d);
        }

        // Assign jobs
        for (int i = 0; i < n; i++) {
            int deadline = Jobs[i][1];
            Integer slot = availableSlots.floor(deadline);  // Latest slot <= deadline
            if (slot != null) {
                availableSlots.remove(slot);
                totalprofit += Jobs[i][col];  // Add profit
                totaljobs++;
            }
        }

        return new int[]{totaljobs, totalprofit};

    }
}
