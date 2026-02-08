package Greedy;

public class checkstring {
    public boolean checkString(String s) {
        int n = s.length();
        int bcount = 0;
        int ans = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'b'){
                bcount++;
            }
            else{
                if(bcount > 0){
                    return false;
                }
            }
        }
        return true;
    }
}
