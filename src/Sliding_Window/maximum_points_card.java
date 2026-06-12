package Sliding_Window;

public class maximum_points_card {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l = n-k;
        int total = 0;
        for(int i = 0; i < n; i++){
            total += cardPoints[i];
        }
        if(l == 0){
            return total;
        }
        int minsum = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < n){
            sum += cardPoints[j];
            if(j-i+1 == l){
                minsum = Math.min(minsum,sum);
                sum -= cardPoints[i];
                i++;
            }
            j++;
        }
        return total-minsum;
    }
}
