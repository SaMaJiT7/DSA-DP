package Leetcode_daily;

public class findtheprefix {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        boolean[] seenA = new boolean[n+1];
        boolean[] seenB = new boolean[n+1];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(A[i] == B[i]){
                count++;
            }
           else {
                if (seenA[B[i]]) {
                    count++;
                }
                if (seenB[A[i]]) {
                    count++;
                }
            }

            seenA[A[i]] = true;
            seenB[B[i]] = true;

            A[i] = count;
        }
        return A;
    }
}
