package Sliding_Window;

import java.util.Arrays;

public class Fruits_problem {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int placed = 0;
        int basketindices = 0;
        Arrays.sort(fruits);
        Arrays.sort(baskets);
        int m = fruits.length;
        int n = baskets.length;

        for(int fruit : fruits){
            while(basketindices < n && baskets[basketindices] < fruit){
                basketindices++;
            }

            if(basketindices < n){
                placed++;
                basketindices++;
            }
        }
        return m - placed;
    }
}
