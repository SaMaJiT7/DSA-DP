package Sliding_Window;

public class numSub {
    static int mod = 1000000007;
    public int numSub(String s) {
        int n = s.length();
        long countones = 0;
        long result = 0;
        for(char ch : s.toCharArray()){
            if(ch == '1'){
                countones++;
            }
            else {
                result = (result + (countones * (countones + 1)) / 2) % mod;
                countones = 0;
            }
        }
        result = (result + (countones * (countones + 1)) / 2) % mod;
        return (int) result;
    }
}
