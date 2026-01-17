package LC_QUestion;

public class minimum_time_all_points {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int time = 0;
        for(int i = 1; i < n; i++){
            int x = points[i-1][0];
            int y = points[i-1][1];

            int x1 = points[i][0];
            int y1 = points[i][1];

            int dx = Math.abs(x1-x);
            int dy = Math.abs(y1-y);

            time += Math.min(dx,dy) + Math.abs(dx-dy);
        }
        return time;
    }
}
