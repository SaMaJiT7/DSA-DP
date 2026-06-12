package Leetcode_daily;

import java.util.Arrays;

public class countSubStrings {
//    int[][] t;
//    public int countSubstrings(String s) {
//        int n = s.length();
//        this.t = new int[n][n];
//        for(int[] row : t){
//            Arrays.fill(row,-1);
//        } // t[i][j] = 0 false   // t[i][j] = 1 true
//        int ans = 0;
//        for(int i = 0; i < n; i++){
//            for(int j = i; j < n; j++){
//                if(ispalindrome(i,j,s)){
//                    ans = ans + 1;
//                }
//            }
//        }
//        return ans;
//    }
//    public boolean ispalindrome(int i, int j, String s){
//        if(i >= j) return true;
//        if(t[i][j] != -1){
//            return (t[i][j] == 1);
//        }
//        if(s.charAt(i) == s.charAt(j)){
//            boolean ok = ispalindrome(i + 1, j - 1, s);
//            t[i][j] = ok ? 1 : 0;
//            return ok;
//        }
//
//        t[i][j] = 0;
//        return false;
//    }
//public int countSubstrings(String s) {
//        int n = s.length();
//        boolean[][] t = new boolean[n][n];
//        for(boolean[] row : t){
//            Arrays.fill(row, false);
//        }
//        int count = 0;
//        for (int L = 1; L <= n; L++) { // length of substrings like L = 1 , 2 , 3 ....
//            for (int i = 0; i + L - 1 < n; i++) {
//                int j = i + L - 1;
//
//                if (i == j) {
//                    t[i][j] = true;
//                } else if ((i + 1) == j) {
//                    boolean b = s.charAt(i) == s.charAt(j);
//                    t[i][j] = b;
//                } else {
//                    t[i][j] = (s.charAt(i) == s.charAt(j) && t[i + 1][j - 1]);
//                }
//
//                if (t[i][j]){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//}

    int count = 0;
    public int countSubstrings(String s) {
    int n = s.length();
    for(int i = 0; i < n; i++){
        check(i,i,s,n);
        check(i,i+1,s,n);
    }
    return count;
}
public void check(int i, int j, String s, int n){
    while(i >=0 && j < n && s.charAt(i) == s.charAt(j)){
        count++;
        i--;
        j++;
    }
}
}
