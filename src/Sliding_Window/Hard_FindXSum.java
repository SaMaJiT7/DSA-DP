package Sliding_Window;
import java.util.*;

public class Hard_FindXSum {
    long sum;
    TreeSet<Pair> Main = new TreeSet<>(); // contain only top x elements
    TreeSet<Pair> Sec = new TreeSet<>();

    private void insert_toSet(Pair pair,int x) {
        if (Main.size() < x || pair.compareTo(Main.last()) < 0) {
            sum += (long) pair.value * pair.freq;
            Main.add(pair);

            if (Main.size() > x) {
                Pair smallest = Main.last();
                sum -= (long) smallest.freq * smallest.value;
                Main.remove(smallest);
                Sec.add(smallest);
            }
        } else {
            Sec.add(pair);
        }
    }

    private void remove_fromSet(Pair pair, int x) {
        if (Main.contains(pair)) {
            sum -= (long) pair.freq * pair.value;
            Main.remove(pair);

            if (!Sec.isEmpty()) {
                Pair largest = Sec.first();
                Sec.remove(largest);
                Main.add(largest);
                sum += (long) largest.freq * largest.value;
            }
        } else {
            Sec.remove(pair);
        }
    }

    public long[] findXSum(int[] nums, int k, int x) {
        Main.clear();
        Sec.clear();
        sum = 0;
        int n = nums.length;
        ArrayList<Long> ans = new ArrayList<>();
        int i = 0, j = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        while (j < n) {
            int oldFreq = mp.getOrDefault(nums[j], 0);
            if (oldFreq > 0) {
                remove_fromSet(new Pair(nums[j], oldFreq), x);
            }
            mp.put(nums[j], oldFreq + 1);
            insert_toSet(new Pair(nums[j], mp.get(nums[j])), x);

            if (j - i + 1 == k) {
                ans.add(sum);
                int old = mp.get(nums[i]);
                remove_fromSet(new Pair(nums[i], old), x);
                if (old == 1) {
                    mp.remove(nums[i]);
                } else {
                    mp.put(nums[i], old - 1);
                    insert_toSet(new Pair(nums[i], mp.get(nums[i])), x);
                }
                i++;
            }
            j++;
        }

        return ans.stream().mapToLong(v -> v).toArray();
    }

    class Pair implements Comparable<Pair> {
        int value, freq;
        public Pair(int v, int f) {
            this.value = v;
            this.freq = f;
        }

        @Override
        public int compareTo(Pair o) {
            int cmp = Integer.compare(o.freq, this.freq); // higher freq first
            if (cmp != 0) return cmp;
            return Integer.compare(o.value, this.value);  // higher value first
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return this.value == p.value && this.freq == p.freq;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, freq);
        }
    }
}
