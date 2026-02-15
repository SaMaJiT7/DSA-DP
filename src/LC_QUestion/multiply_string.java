package LC_QUestion;

import java.util.Locale;
import java.util.Objects;

public class multiply_string {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int n = num2.length();
        StringBuilder result = new StringBuilder("0");
        for(int d = n-1; d >= 0; d--){
            int digit = num2.charAt(d) - '0';
            StringBuilder partial = multiple(num1,digit);
            int zeroes = n-1-d;
            for(int i = 0; i < zeroes; i++) {
                partial = partial.append('0');
            }
            result = addStrings(result,partial);
        }
        return result.toString();
    }
    public StringBuilder multiple(String n1, int d){
        int res = 0;
        int carry = 0;
        StringBuilder str = new StringBuilder();
        for(int i = n1.length()-1; i >= 0; i--){
            res = (n1.charAt(i)- '0') * d + carry;
            str.append(res % 10);
            carry = res / 10;
        }
        if(carry > 0){
            str.append(carry);
        }
        return str.reverse();
    }
    public StringBuilder addStrings(StringBuilder result,StringBuilder partial){
        int i = result.length() - 1;
        int j = partial.length() - 1;
        StringBuilder str = new StringBuilder();
        int carry = 0;
        int sum;

        while(i >= 0 || j >= 0 || carry > 0){
            sum = carry;
            if(i>=0) sum += result.charAt(i--)-'0';
            if(j>=0) sum += partial.charAt(j--)-'0';
            str.append(sum%10);
            carry = sum/10;
        }
        return str.reverse();
    }
}
