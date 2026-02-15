package ALGo_In_Array;

public class balanced_str {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxlen = 0;
        for(int i = 0; i < n; i++){
            int[] freq = new int[26];
            for(int j = i; j < n; j++){
                freq[s.charAt(j)-'a']++;

                if(isbalanced(freq)){
                    maxlen = Math.max(maxlen,j-i+1);
                }
            }
        }
        return maxlen;
    }
    public boolean isbalanced(int[] freq){
        int common = 0;
        for(int i = 0 ; i < freq.length; i++){
            if(freq[i] == 0) {
                continue;
            }
            else {
                if(common == 0) {
                    common = freq[i];
                }
                else if(freq[i] != common){
                    return false;
                }
            }
        }
        return true;
    }
}
