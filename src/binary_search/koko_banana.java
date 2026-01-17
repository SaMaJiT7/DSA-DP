package binary_search;

public class koko_banana {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int end = 0;
        for(int i = 0; i < n; i++){
            end = Math.max(end,piles[i]);
        }
        int start = 1;
        int ans = end;

        while(start <= end){
            int mid = start + (end-start)/2;



           if(canfinish(piles,h,mid)){
               ans = mid;
               end = mid - 1;
           }
           else{
               start = mid + 1;
           }
        }
        return ans;
    }
    public boolean canfinish(int[] piles,int h, int mid){
        long total = 0;
        for (int pile : piles) {
            total += (pile + mid - 1) / mid; // ceil division
        }
        return total <= h;
    }
}
