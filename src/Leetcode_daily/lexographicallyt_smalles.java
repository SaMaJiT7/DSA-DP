package Leetcode_daily;

import java.util.ArrayDeque;
import java.util.Arrays;

public class lexographicallyt_smalles {
        public String generateString(String str1, String str2) {
            int n = str1.length();
            int m = str2.length();
            int l = n + m -1;
            boolean[] canChange = new boolean[l];
            Arrays.fill(canChange,false);

            StringBuilder word = new StringBuilder("$".repeat(l));

            //Processing the T in str1.
            for(int i = 0; i < n; i++){
                if(str1.charAt(i) == 'T'){
                    int i_ = i;
                    for(int j = 0; j < m; j++){
                        if(word.charAt(i_) != '$' && word.charAt(i_) != str2.charAt(j)) {
                            return "";
                        }
                        word.setCharAt(i_, str2.charAt(j));
                        i_++;
                    }
                }
            }

            //fill with all the 'a'.
            for(int i = 0; i < l; i++){
                if(word.charAt(i) == '$'){
                    word.setCharAt(i,'a');
                    canChange[i] = true;
                }
            }

            //Processing all the F in the str1 now.
            for(int i = 0; i < n; i++){
                if(str1.charAt(i) == 'F'){
                    if(str2.equals(word.substring(i,i+m))){
                        boolean changed = false;
                        for(int k = i+m-1; k >= i; k--){
                            if(canChange[k]){
                                word.setCharAt(k,'b');
                                changed = true;
                                break;
                            }
                        }
                        if(!changed){ //Not able to change any character to break the equality.
                            return "";
                        }
                    }
                }
            }

            return word.toString();
        }

}
