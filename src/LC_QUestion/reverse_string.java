package LC_QUestion;

import java.util.HashSet;

public class reverse_string {
    public void reverseString(char[] s) {
        int n = s.length;
        int i = 0;
        int j = s.length-1;

        while(i <= j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        while(i <= j) {
            char ch = arr[i];
            char ch1 = arr[j];
            if(isVowel(ch) && isVowel(ch1)){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            if(!isVowel(ch)){
                i++;
            }
            if(!isVowel(ch1)){
                j--;
            }
        }
        return new String(arr);
    }
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }
}
