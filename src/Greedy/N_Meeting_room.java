package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Meeting_room {
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        // Create indices array
        Integer[] indices = new Integer[end.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        // Sort indices based on keys array (ascending)
        Arrays.sort(indices, (a, b) -> Integer.compare(end[a], end[b]));

        // Reorder both arrays using sorted indices
        int[] sortedEnd = new int[end.length];
        int[] sortedStart = new int[start.length];
        for (int i = 0; i < indices.length; i++) {
            sortedEnd[i] = end[indices[i]];
            sortedStart[i] = start[indices[i]];
        }

        // Copy back to originals (for in-place sorting)
        System.arraycopy(sortedEnd, 0, end, 0, end.length);
        System.arraycopy(sortedStart, 0, start, 0, start.length);

        int count = 1;
        int endtime = end[0];

        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i < n; i++){
            if(start[i] > endtime){
                count++;
                endtime = end[i];

            }
        }
        return count;
    }
}
