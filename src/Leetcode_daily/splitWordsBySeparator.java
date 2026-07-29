package Leetcode_daily;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class splitWordsBySeparator {
    static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        List<String> words = Arrays.stream(new String[]{"one.two.three", "four.five", "six"}).toList();
        char separator = '.';
        List<String> ans =splitWordsBySeparator(words,separator);
        for(String val : ans){
            out.print(val + " ");
        }
        out.flush();
    }
        public static List<String> splitWordsBySeparator(List<String> words, char separator) {
            List<String> answer = new ArrayList<>();
            String regexToken = Pattern.quote(String.valueOf(separator));
            for(String word : words){
                String[] arr = word.split("\\" + separator);
                for(String val : arr){
                    if(!val.isEmpty()){
                        answer.add(val);
                    }
                }

            }
            return answer;
    }
}
