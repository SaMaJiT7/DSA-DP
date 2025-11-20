package Greedy;

public class make1toleft {
    public int maxOperations(String s) {
        int n = s.length();
        int one = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1'){
                one++;
            }
            else if(s.charAt(i) == '0' && i > 0 && s.charAt(i - 1) == '1'){
                count += one;
            }
        }
        return count;
    }
}
