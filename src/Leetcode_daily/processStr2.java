package Leetcode_daily;

public class processStr2 {
    public char processStr(String s, long k) {
        int n = s.length();
        long length = 0;
        for(char ch : s.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                length += 1;
            }
            else if(ch == '#'){
                length = 2*length;
            }
            else if(ch == '*'){
               if(length > 0){
                   length = length-1;
               }
            }
        }

        if(k >= length){
            return '.';
        }

        long currentlength = length;
        for(int i = n-1; i >= 0; i--){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                if(k == currentlength-1){
                    return ch;
                }
                currentlength -= 1;
            }
            else if(ch == '#'){
                long prevLength = currentlength / 2;

                if(k >= prevLength){
                    k = k - prevLength;
                }

                currentlength = prevLength;
            }
            else if(ch == '%'){
                k = currentlength - 1 - k;
            }
            else if(ch == '*'){
                currentlength++;
            }
        }
        return '.';
    }
}
