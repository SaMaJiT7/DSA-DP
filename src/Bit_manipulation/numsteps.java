package Bit_manipulation;

public class numsteps {

    public int numSteps(String s) {
        int n = s.length();
        int carry = 0;
        int count = 0;
        for(int i = n-1; i > 0; i--){
            int bit = s.charAt(i) - '0';
            int sum = bit + carry;
            if(sum == 1){
                count += 2;
                carry = 1;
            }
            else{
                count++;
            }
        }
        return count + carry;
    }
}
