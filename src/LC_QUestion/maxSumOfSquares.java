package LC_QUestion;

import ALGo_In_Array.StringB;

public class maxSumOfSquares {
    public static String maxSumOfSquares(int num, int sum) {
       if(sum > 9*num){
           return "";
       }
       StringBuilder s = new StringBuilder(num);
       for(int i = 0; i < num; i++){
           s.append('0');
       }
       String s1 = s.toString();

       StringBuilder sb = new StringBuilder(s);
       for(int i = 0; i < num; i++){
           if(sum <= 9){
               char newChar = (char)(sb.charAt(i) + sum);
               sb.setCharAt(i,newChar);
               break;
           }
           else{
               sum -= 9;
               sb.setCharAt(i,'9');
           }
       }
      return sb.toString();
    }
}
