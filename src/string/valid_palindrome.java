package string;

public class valid_palindrome {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        s = s.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            while(i < s.length() && (s.charAt(i) == ' ' || !Character.isLetterOrDigit(s.charAt(i)))){
                i++;
            }
            while(j >= 0 && (s.charAt(j) == ' ' || !Character.isLetterOrDigit(s.charAt(j)))){
                j--;
            }
            if(i < s.length() && j >= 0) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }
}
