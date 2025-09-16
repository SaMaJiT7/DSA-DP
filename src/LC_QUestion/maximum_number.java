package LC_QUestion;

import java.util.HashSet;

public class maximum_number {
    public int canBeTypedWords(String text, String brokenLetters) {
        int ans = 0;
        boolean cantype = false;
        HashSet<Character> map = new HashSet<>();
        for(char ch : brokenLetters.toCharArray()){
            map.add(ch);
        }

//        for(int i = 0; i < text.length(); i++){
//            if(map.contains(text.charAt(i))){
//                flag = true;
//            }
//            else if(text.charAt(i) == ' '){
//                if(!flag) {
//                    ans += 1;
//                }
//                flag = false;
//            }
//           if(!flag){
//               ans++;
//           }
//        }
        String[] arr = text.split(" ");
        for(String word : arr){
            for(char ch : word.toCharArray()){
                if(!map.contains(ch)){
                    cantype = true;
                }
            }
            if(cantype){
                ans++;
            }
        }
        return ans;
    }
}
