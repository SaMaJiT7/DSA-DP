package Sliding_Window;

public class grumpy_owner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int maxunsatiefied = 0;
        int unsatiefied = 0;

        for(int i = 0; i < minutes; i++){
            unsatiefied  += customers[i] * grumpy[i];
        }
        maxunsatiefied = unsatiefied;
        int i = 0;
        int j = minutes;
        while(j < n){
            unsatiefied += customers[j] * grumpy[j];
            unsatiefied -= customers[i] * grumpy[i];
            i++;
            j++;

            maxunsatiefied = Math.max(maxunsatiefied,unsatiefied);
        }
        for(int k = 0; k < n; k++){
            if(grumpy[k] == 0){
                maxunsatiefied += customers[k];
            }
        }
        return maxunsatiefied;
    }
}
