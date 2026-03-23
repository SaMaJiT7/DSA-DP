package Leetcode_daily;

public class minimum_totFlip {
    public int minFlips(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int result = Integer.MAX_VALUE;
        int flip1 = 0;
        int flip2 = 0;
        int minflip = Integer.MAX_VALUE;
        while(j < 2*n){
            char expectedchars1 = (j % 2 == 0) ? '1' : '0';
            char expectedchars2 = (j % 2 == 0) ? '0' : '1';
            if(s.charAt(j%n) !=  expectedchars1) flip1++;
            if(s.charAt(j%n) != expectedchars2) flip2++;

            if(j-i+1 > n){
                expectedchars1 = (i % 2 == 0) ? '1' : '0';
                expectedchars2 = (i % 2 == 0) ? '0' : '1';
                if(s.charAt(i%n) != expectedchars1){
                    flip1 -= 1;
                }
                if(s.charAt(i%n) != expectedchars2){
                    flip2 -= 1;
                }
                i++;
            }
            if(j-i+1 == n){
                minflip = Math.min(flip1,flip2);
                result = Math.min(minflip,result);
            }

            j++;
        }
        return result;
    }
}
