package Leetcode_daily;

import java.util.HashSet;

public class password_strength {
    public int passwordStrength(String password) {
        int n = password.length();
        int strength = 0;
        HashSet<Character> unique = new HashSet<>();
        for(char ch : password.toCharArray()){
            if(unique.contains(ch)){
                continue;
            }
            unique.add(ch);

            if(ch >= 'a' && ch <= 'z'){
                strength += 1;
            }
            else if(ch >= 'A' && ch <= 'Z'){
                strength += 2;
            }
            else if(ch >= '0' && ch <= '9'){
                strength += 3;
            }
            else{
                String special = "!@#$";
                for(char spec : special.toCharArray()){
                    if(ch == spec){
                        strength += 5;
                    }
                }
            }
        }

        return strength;
    }
}
