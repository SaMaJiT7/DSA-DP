package ALGo_In_Array;

import java.util.ArrayList;
import java.util.List;

public class encode_decode {
    public String encode(List<String> strs) {
        StringBuilder encoded_string = new StringBuilder();
        for(String str : strs){
            encoded_string.append(str);
            encoded_string.append('{');
        }
        return encoded_string.toString();
    }

    public List<String> decode(String str) {
        char[] STRarr = str.toCharArray();
        List<String> answer = new ArrayList<>();
        StringBuilder Str = new StringBuilder();
        for(char ch : STRarr){
            if(ch != '{'){
                Str.append(ch);
            }
            else{
                answer.add(Str.toString());
                Str = new StringBuilder();
            }
        }
        return answer;
    }
}
