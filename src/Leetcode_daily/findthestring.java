package Leetcode_daily;

public class findthestring {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        StringBuilder word = new StringBuilder("*".repeat(n));

        for(int i = 0; i < n; i++){

            for(int j = 0; j < i; j++){
                if(lcp[j][i] != 0){
                    word.setCharAt(i,word.charAt(j));
                    break;
                }
            }

            if(word.charAt(i) == '*'){
                boolean[] cantuse = new boolean[26];

                for(int j = 0; j < i; j++){
                    if(lcp[j][i] == 0) {
                        cantuse[word.charAt(j) - 'a'] = true;
                    }
                }

                for(int idx = 0; idx < 26; idx++){
                    if(!cantuse[idx]){
                        word.setCharAt(i, (char) (idx+'a'));
                        break;
                    }
                }
                //we could never fill the ith.
                if(word.charAt(i) == '*'){
                    return "";
                }
            }
        }
        return (checklcp(word,lcp)) ? word.toString() : "";
    }

    public boolean checklcp(StringBuilder word,int[][] lcp){
        int n = lcp.length;

        for(int i = 0; i < n; i++){
            if(word.charAt(i) != word.charAt(n-1)){
                if(lcp[i][n-1] != 0) return false;
            }
            else{
                if(lcp[i][n-1] != 1) return false;
            }
        }

        for(int j = 0; j < n; j++){
            if(word.charAt(n-1) != word.charAt(j)){
                if(lcp[n-1][j] != 0) return false;
            }else{
                if(lcp[n-1][j] != 1) return false;
            }
        }

        for(int i = n-2; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                if(word.charAt(i) != word.charAt(j)){
                    if(lcp[i][j] != 0) return false;
                }else{
                    if(lcp[i][j] != 1+lcp[i+1][j+1]) return false;
                }
            }
        }
        return true;
    }
}
