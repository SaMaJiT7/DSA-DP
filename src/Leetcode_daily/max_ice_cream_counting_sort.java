package Leetcode_daily;

public class max_ice_cream_counting_sort {
    public int maxIceCream(int[] costs, int coins) {
        int maxcosts = 0;
        for(int cost : costs){
            maxcosts = Math.max(cost,maxcosts);
        }
        int[] freq = new int[maxcosts+1];
        for(int cost : costs){
            freq[cost]++;
        }
        int ice = 0;

        for(int price = 1; price <= maxcosts; price++){
            if(freq[price] == 0){
                continue;
            }
            int buy = Math.min(freq[price], coins / price);

            ice += buy;
            coins -= buy * price;

            if(coins < price) break;
        }
        return ice;
    }
}
