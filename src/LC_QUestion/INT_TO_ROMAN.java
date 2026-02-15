package LC_QUestion;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class INT_TO_ROMAN {
    public String intToRoman(int num) {
            StringBuilder str = new StringBuilder();
            int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
            String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
            for(int i = 0; i < values.length; i++){

                while(num >= values[i]){
                    num = num - values[i];
                    str.append(symbols[i]);
                }
            }
            return str.toString();
    }
}
