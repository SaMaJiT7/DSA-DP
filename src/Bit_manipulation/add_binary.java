package Bit_manipulation;

public class add_binary {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        if(m > n){
            return addBinary(b,a);
        }

        int carry = 0;
        int j = m-1;
        StringBuilder ans = new StringBuilder();
        for(int i = n-1 ; i >= 0; i--){

            int sum = a.charAt(i) - '0'+ carry;

            if(j >= 0){
                sum += b.charAt(j--) - '0';
            }

            ans.append(sum % 2);
            carry = sum/2;
        }
        if(carry > 0){
            ans.append('1');
        }
        return ans.reverse().toString();
    }
}
