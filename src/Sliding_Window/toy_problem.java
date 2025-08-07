package Sliding_Window;

import java.util.HashMap;

public class toy_problem {
    public static void main(String[] args) {
        int[] toys;
        toys = new int[]{1, 2, 1, 2, 5, 6, 4, 3, 2};
        System.out.println(totaltoys(toys));
    }

    public static int totaltoys(int[] toys) {
        int n = toys.length;
        int i = 0;
        int j = 0;
        int max = -1;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(j < n){
            map.put(toys[j],map.getOrDefault(toys[j],0)+1);

            if(map.size() == 2){
                max = Math.max(max,j-i+1);
            }
            else if(map.size() > 2){
                while (map.size() > 2){
                    int toy = toys[i];
                    map.put(toy,map.get(toy)-1);
                    if(map.get(toy) == 0){
                        map.remove(toy);
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }
}
