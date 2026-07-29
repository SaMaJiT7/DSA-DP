package Leetcode_daily;

public class gcdoddeven {
    public int gcdOfOddEvenSums(int n) {
        if (n <= 0) return 0;
        long count = n;

        long oddLastTerm = (1 + (count-1) * 2);
        long evenLastTerm = (2 + (count-1) * 2);

        long oddSum = (count* (1 + oddLastTerm))/2;
        if (count == 1) return (int) oddSum;
        long evenSum = (count * (2 + evenLastTerm))/2;

        return (int) gcd(oddSum,evenSum);
    }
    public long gcd(long a, long b){
        while(b != 0){
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
