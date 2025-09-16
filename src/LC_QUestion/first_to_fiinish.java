package LC_QUestion;

public class first_to_fiinish {
    public int earliestTime(int[][] tasks) {
        int min = Integer.MAX_VALUE;
        int n = tasks.length;
        for(int  i = 0; i < n; i++){
            int finishtime = tasks[i][0] + tasks[i][1];
            min = Math.min(min,finishtime);
        }
        return min;
    }
}
