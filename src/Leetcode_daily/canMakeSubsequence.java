package Leetcode_daily;

import java.util.Arrays;

public class canMakeSubsequence {
    public boolean canMakeSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        int n = s.length();
        int m = t.length();
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        Arrays.fill(left,-1);
        Arrays.fill(right,-1);

        int j = 0;
        for(int i = 0; i < n; i++){
            while(j < m && s.charAt(i) != t.charAt(j)){
                j++;
            }

            if(j < m){
                left[i] = j;
                j++;
            }else{
                break;
            }
        }

        int k = m-1;
        for(int i = n-1; i >= 0; i--){
            while(k >= 0 && s.charAt(i) != t.charAt(k)){
                k--;
            }

            if(k >= 0){
                right[i] = k;
                k--;
            }
            else{
                break;
            }
        }

        if(left[n-1] != -1){
            return true;
        }

        for(int i = 0; i < n; i++){
            if(i == 0){
                if(right[1] != -1 && right[1] > 0){
                    return true;
                }
            }
            else if(i == n-1){
                if(left[n-2] != -1 && left[n - 2] < m - 1){
                    return true;
                }
            }
            else{
                int leftmax = left[i-1];
                int rightmax = right[i+1];

                if(leftmax != -1 && rightmax != -1 &&  leftmax < rightmax){
                    return true;
                }
            }
        }
        return false;
    }
}
