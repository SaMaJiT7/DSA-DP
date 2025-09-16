package prefix_sum;

public class maximum_population {
    public int maximumPopulation(int[][] logs) {
        int n = logs.length;
        int[] changes = new int[101];
        final int offset = 1950;

        for(int[] log : logs){
            int birth = log[0]-offset;
            int death = log[1]-offset;
            changes[birth]++;
            changes[death]--;
        }
        int currentPopulation = 0;
        int maxPopulation = 0;
        int maxYear = 0;

        for(int i = 0; i < n; i++){
            maxPopulation = maxPopulation + changes[i];
            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                maxYear = i;
            }
        }
        return maxYear + offset;
    }
}
