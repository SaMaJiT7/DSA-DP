package binary_search;

public class MINDAYS {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int low = 1;
        int high = 0;
        for(int i = 0; i < n; i++){
            high = Math.max(high,bloomDay[i]);
        }
        int ans = -1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(canmake(bloomDay,mid,m,k)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean canmake(int[] bloomDay,int mid,int m,int k){
        int n = bloomDay.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(mid >= bloomDay[i]){
                count++;
            }
            else{
                count = 0;
            }

            if(count == k){
                m--;
                count = 0;
            }
        }
        return (m <= 0) ? true : false;
    }
}
