package Sliding_Window;

import java.util.HashMap;

public class fruit_problem {
    public static void main(String[] args) {

    }

    public int totalFruit(int[] fruits) {
        int i = 0;
        int j = 0;
        int n = fruits.length;
        int max = -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (j < n) {

            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);


            if (map.size() > 2) {
                while (map.size() > 2) {
                    map.put(fruits[i], map.get(fruits[i]) - 1);
                    if (map.get(fruits[i]) == 0) {
                        map.remove(fruits[i]);
                    }
                    i++;
                }
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}