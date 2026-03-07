package string;

import java.util.HashSet;

public class string_k_size {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int totalsub = 1 << k;
        HashSet<String> unique = new HashSet<>();
        int i = 0;
        int j = 0;
        while(j < n){
            if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 == k){
                unique.add(s.substring(i,j+1));
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return unique.size() == totalsub;
    }
}
