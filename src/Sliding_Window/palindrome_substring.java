package Sliding_Window;

public class palindrome_substring {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] freq = new int[26];
        for(char ch : s1.toCharArray()){
            freq[ch-'a']++;
        }
        int i = 0;
        int j = 0;
        while(j < m){
            int ch = s2.charAt(j) - 'a';
            freq[ch]--;

            if(j-i+1 == n){
                boolean flag = true;
                for(int k = 0; k < 26; k++){
                    if(freq[k] != 0){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    return true;
                }

                int leave = s2.charAt(i) - 'a';
                freq[leave]++;
                i++;
            }
            j++;
        }
        return false;
    }
}
