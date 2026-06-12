package Leetcode_daily;

public class string_equal_operations_II {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        int[] even = new int[26];
        int[] odd = new int[26];
        for(int i = 0; i < n; i++){
            if((i&1) == 0){
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            }
            else{
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
        }
        for(int i = 0; i < 26; i++){
            if(odd[i] != 0 || even[i] != 0){
                return false;
            }
        }
        return true;
    }
}
