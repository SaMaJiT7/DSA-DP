package BackTracking;

public class sum_string {
    public boolean isSumString(String s) {
        int n = s.length();

        for(int i  = 1 ; i < n ; i++){
            for(int j = 1; i+j < n ; j++){
                if(checksum(s,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checksum(String s,int first , int i , int j){
        String s1 = s.substring(first,i);
        String s2 = s.substring(first+i,j);
        String s3 = string_sum(s1,s2);

        int len_s3 = s3.length();

        if(len_s3 > s.length()-i-j-first){
            return false;
        }

        if(s3.equals(s.substring(first + i + j, len_s3))){
            if(s.length() == first+i+j+len_s3){
                return true;
            }
            return checksum(s,first+i,j,len_s3);
        }
        return false;
    }

    static String string_sum(String s1, String s2){
        StringBuilder result = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? s1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? s2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.append(sum % 10);
        }
        return result.reverse().toString();
    }
}
