package binary_search;

public class shipped_weights {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = Integer.MIN_VALUE;
        int total = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(weights[i],max);
            total += weights[i];
        }
        int low = max;
        int high = total;

        while(low < high){
            int mid = low + (high - low)/2;
            if(getdays(weights,mid,days)){
                high = mid ;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean getdays(int[] weights, int capacity,int days){
        int day = 1;
        int load = 0;
        for(int i = 0; i < weights.length; i++){
            load += weights[i];
            if(load > capacity){
                day = day+1;
                load = weights[i];

                if(day > days) return false;
            }
        }
        return true;
    }
}
