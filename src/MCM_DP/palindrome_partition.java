package MCM_DP;

import java.util.Arrays;

public class palindrome_partition {
    static int[][] t = new int[1001][1001];

    public static void main(String[] args) {
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        String s = "NITInN";
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = s.length()-1;
        System.out.println(palindrome_memo(sb,i,j));
    }

    public static int palindromeparti(StringBuilder s, int i, int j){
        if(i >= j){
            return 0;
        }


        if(ispalindrome(s, i, j)){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int temp = palindromeparti(s, i, k) + palindromeparti(s, k+1, j) + 1;
            min = Math.min(min, temp);
        }
        return min;
    }
    static int palindrome_memo(StringBuilder s, int i, int j) {
            if (i >= j) {
                return 0;
            }
            if (t[i][j] != -1) {
                return t[i][j];
            }
            if (ispalindrome(s, i, j)) {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            for (int k = i; k < j; k++) {
                int left;
                int right;
                if (t[i][k] != -1) {
                    left = t[i][k];
                } else {
                    left = palindrome_memo(s, i, k);
                    t[i][k] = left;
                }
                if (t[k + 1][j] != -1) {
                    right = t[k + 1][j];
                }
                else {
                    right = palindrome_memo(s, k + 1, j);
                    t[k+1][j] = right;
                }
                int temp = left + right + 1;
                min = Math.min(min, temp);
            }
            return t[i][j] = min;
        }

        static boolean ispalindrome(StringBuilder s, int i, int j) {
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }


