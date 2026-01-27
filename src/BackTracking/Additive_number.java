package BackTracking;

public class Additive_number {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        if(n < 3){
            return false;
        }
        for(int i = 1; i <= n-2; i++){
            for(int j = i + 1; j <= n-1; j++){
                String s = num.substring(0,i);
                String s1 = num.substring(i,j);
                if(s.length() > 1 && s.charAt(0) =='0') continue;
                if(s1.length() > 1  && s1.charAt(0) == '0') continue;


                if(helper(num,j,s,s1)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(String s, int idx, String prev1 ,String prev2){
        if(idx == s.length()){
            return true;
        }

        String sum = addStrings(prev1 , prev2);


        if(!s.startsWith(sum,idx))return false;


        return helper(s,idx+sum.length(),prev2,sum);
    }
    private String addStrings(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int x = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int y = (j >= 0) ? b.charAt(j--) - '0' : 0;

            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}
