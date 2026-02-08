package Greedy;

public class min_del_str_bal {
    public int minimumDeletions(String s) {
        int n = s.length();
        int bcount = 0;
        int deletions =0;
        for(char c : s.toCharArray()){
            if(c == 'b'){
                bcount = bcount+1;
            }
            else{
                deletions = Math.min(deletions+1,bcount);
            }
        }
        return deletions;
    }
}
