package LC_QUestion;

import java.util.Arrays;
import java.util.List;

public class potion_brew {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] finishtime = new long[n];
        Arrays.fill(finishtime,0);

        for(int i = 0; i < m; i++){
            finishtime[0] += 1L * skill[0] * mana[i];

            for(int j = 1; j < n; j++) {
                finishtime[j] = Math.max(finishtime[j - 1], finishtime[j]) + 1L * skill[j] * mana[i];
            }

            for (int k = n - 1; k > 0; k--) {
                finishtime[k - 1] = finishtime[k] - 1L * skill[k] * mana[i];
            }
        }
        return finishtime[n-1];
    }
}
