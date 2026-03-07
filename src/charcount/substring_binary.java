package charcount;

public class substring_binary {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int count = 0;
        int prevcount = 0;
        int currcount = 1;
        for(int i = 1; i <= n-1; i++){
            if(s.charAt(i) != s.charAt(i-1)){
                prevcount = currcount;
                currcount = 1;
                count += Math.min(prevcount,currcount);
            }
            else{
                currcount++;
            }
        }
        count += Math.min(prevcount,currcount);
        return count;
    }
}
