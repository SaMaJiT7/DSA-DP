package LC_QUestion;

import java.util.ArrayList;
import java.util.Collections;

public class ExamTracker {
    private ArrayList<Integer> times;
    private ArrayList<Long> prefix;
    public ExamTracker() {
        times = new ArrayList<>();
        prefix = new ArrayList<>();
    }

    public void record(int time, int score) {
        times.add(time);
        long lastSum = prefix.isEmpty() ? 0 : prefix.get(prefix.size() - 1);
        prefix.add(lastSum + score);
    }

    public long totalScore(int startTime, int endTime) {
        int l = Collections.binarySearch(times,startTime);
        if (l < 0) l = -l - 1;
        int r = Collections.binarySearch(times,endTime);
        if (r < 0) r = -r - 2;


        if (l > r || l >= times.size() || r < 0) return 0;

        long total = prefix.get(r);
        if (l > 0) total -= prefix.get(l - 1);

        return total;
    }
}
