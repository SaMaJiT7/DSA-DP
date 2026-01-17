package LC_QUestion;

public class largest_area_under_rec {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxside = 0;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                //x coordinate
                //topright
                int x1 = topRight[i][0];
                int x3 = topRight[j][0];
                int xr = Math.min(x3,x1);
                //bottomleft
                int x2 = bottomLeft[i][0];
                int x4 = bottomLeft[j][0];
                int xb = Math.max(x2,x4);

                //y coordinate
                //topright
                int y1 = topRight[i][1];
                int y3 = topRight[j][1];
                int yr = Math.min(y1,y3);
                //bottomleft
                int y2 = bottomLeft[i][1];
                int y4 = bottomLeft[j][1];
                int yb = Math.max(y2,y4);

                int width = Math.max(0, xr - xb);
                int height = Math.max(0, yr - yb);
                int s = Math.min(width,height);
                maxside = Math.max(maxside,s);
            }
        }
        return maxside * maxside;
    }
}
