package LC_QUestion;

public class check_capital {
//    public boolean detectCapitalUse(String word) {
//        int n = word.length();
//        String check = word;
//        if(check.toLowerCase().equals(word)){
//            return true;
//        }
//        else if(check.toUpperCase().equals(word)){
//            return true;
//        }
//        else if((check.substring(0,1).toUpperCase()+check.substring(1,n).toLowerCase()).equals(word)){
//            return true;
//        }
//        return false;
//    }
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            if(Character.isUpperCase(word.charAt(i))){
                count++;
            }
        }
        return count == 0 || count == word.length() || (count == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
