package LC_QUestion;

import java.util.Arrays;

public class plus_one_leetcode {
//    [1,2,3]
//[4,3,2,1]
//[9]
    public static void main(String[] args) {
        int[] arr = {9};
        int[] a = plusOne(arr);
        for(int c : a){
            System.out.println(c);
        }
    }
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }else{
                digits[i] = 0;
            }
        }

        int[] newdigits = new int[n+1];
        newdigits[0] = 1;
        return newdigits;
    }
}
