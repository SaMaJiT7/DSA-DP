package Greedy;

public class break_palindrome {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n == 1){
            return "";
        }
        char[] pali = palindrome.toCharArray();
        for(int i = 0; i < n/2; i++){
            if(pali[i] != 'a'){
                pali[i] = 'a';
                return new String(pali);
            }
        }
        pali[n-1] = 'b';
        return new String(pali);
    }
}
