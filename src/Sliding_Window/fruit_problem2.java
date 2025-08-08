package Sliding_Window;

public class fruit_problem2 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int placed = 0;
        int unplaced = 0;
        boolean[] used = new boolean[baskets.length];

        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < baskets.length; j++) {
                if (!used[j] && fruits[i] <= baskets[j]) {
                    placed = placed + 1;
                    used[j] = true;
                    break;
                }
            }
        }
        return fruits.length - placed;
    }
}
