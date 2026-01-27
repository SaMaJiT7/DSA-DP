package practice_question;

import java.util.Arrays;
import java.util.HashMap;

public class Nstraighthand {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        int total = n / groupSize;
        int count = 0;
        int prev = 0;
        Arrays.sort(hand);
        HashMap<Integer, Integer> map = new HashMap<>();
        if (n % groupSize != 0) {
            return false;
        }
        for (int val : hand) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for (int i = 0; i < n; i++) {

            int now = hand[i];
            if (map.get(now) == 0) {
                continue;
            }

            for (int j = 0; j < groupSize; j++) {
                int target = now + j;


                if (map.getOrDefault(target, 0) > 0) {
                    map.put(target, map.get(target) - 1);
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
