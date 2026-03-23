package Leetcode_daily;

import RECURSION.sequence;
import permutation.Introduction;

import java.util.ArrayList;

public class Fancy_sequence {
    static private long M = 1000000007L;
    long add = 0;
    long mult = 1;
    ArrayList<Long> sequence = new ArrayList<>();
    public Fancy_sequence() {

    }

    public void append(int val) {
        long in = (((val - add) % M + M) * (pow(mult,M-2))) % M;
        sequence.add(in);
    }

    public void addAll(int inc) {
        add  = (add+inc) % M;
    }

    public void multAll(int m) {
        mult = (mult * m) % M;
        add = (add * m) % M;
    }

    public int getIndex(int idx) {
        if(idx >= sequence.size()) return -1;
        long ans = (sequence.get(idx) * mult + add) % M;
        return (int) ans;
    }

    public long pow(long a, long b){
        long result = 1;
        a = a % M;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % M;
            }
            a = (a * a) % M;
            b = b >> 1;
        }
        return result;
    }

}
