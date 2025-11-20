package LC_QUestion;

public class reverse_degree {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i = 1; i <= s.length(); i++){
            int rev = 26 - (s.charAt(i) -'a');
            sum += i * rev;
        }
        return sum;
    }
}
