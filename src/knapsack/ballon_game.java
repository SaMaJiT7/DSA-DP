package knapsack;

public class ballon_game {
    public int minCost(String colors, int[] neededTime) {
        int groupsum = neededTime[0];
        int groupmax = neededTime[0];
        int totaltime = 0;
        for(int i = 1; i < colors.length();i++){
            char prev = colors.charAt(i-1);
            char color = colors.charAt(i);
            if(prev == color){
                groupsum += neededTime[i];
                groupmax = Math.max(groupmax,neededTime[i]);
            }
            else {
                totaltime += (groupsum - groupmax);

                groupsum = neededTime[i];
                groupmax = neededTime[i];
            }
        }
        totaltime += (groupsum - groupmax);

        return totaltime;
    }

        
}
