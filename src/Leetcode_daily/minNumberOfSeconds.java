package Leetcode_daily;

public class minNumberOfSeconds {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int n = workerTimes.length;
        long mintime = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            mintime = Math.min(mintime,workerTimes[i]);
        }
        long low = 1;
        long high = mintime * (((long) mountainHeight * (mountainHeight+1))/ 2);

        long result = 0;
        while(low <= high){
            long mid = low + (high-low)/2;

            if(check(workerTimes,mountainHeight,mid)){
                result = mid;
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }
    public boolean check(int[] workerTimes,int H,long t){
        long sum = 0;
        for(int w : workerTimes){
            long x = (long)((-1 + Math.sqrt(1.0 + (8.0 * t)/w)) / 2);
            sum += x;
            if(sum >= H) return true;
        }
        return false;
    }
}
