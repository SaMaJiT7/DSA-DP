package prefix_sum;

import java.util.*;

public class Snuke_prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        long C = sc.nextLong();
//
//
//        int MAX_DAY = 10001;
//
//        long[] diff = new long[MAX_DAY+1];
//
//        for(int i = 0; i < N; i++){
//            int ai = sc.nextInt();
//            int bi = sc.nextInt();
//            int ci = sc.nextInt();
//
//            diff[ai] += ci;
//            diff[bi + 1] -= ci;
//
//        }
//
//
//        long totalCost = 0;
//        long currentCost = 0;
//        for (int i = 1; i <= MAX_DAY; i++) {
//            currentCost += diff[i];
//            totalCost += Math.min(currentCost, C);
//        }
//        System.out.println(totalCost);
        int N = sc.nextInt();
        long C = sc.nextLong();

        int[] ai = new int[N];
        int[] bi = new int[N];
        int[] ci = new int[N];

        for(int i = 0; i < N; i++) {
            ai[i] = sc.nextInt();
            bi[i] = sc.nextInt();
            ci[i] = sc.nextInt();
        }

        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i <N; i++){
            set.add(ai[i]);
            set.add(bi[i]+1);
        }
        int idx = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int it: set) {
            map.put(it,idx++);
        }

        long[] diff = new long[set.size()+1];
        for(int i = 0; i < N; i++){
            diff[map.get(ai[i])] += ci[i];
            diff[map.get(bi[i]+1)] -= ci[i];
        }
        for(int i= 1; i <= idx; i++){
            diff[i] += diff[i-1];
        }

        int[] a = set.stream().mapToInt(Integer::intValue).toArray();

        long ans = 0;
        for(int i = 1; i < a.length; i++){
            long span = a[i] - a[i-1];
            ans += Math.min(diff[i-1], C) * span;
        }
        System.out.println(ans);
    }
}
