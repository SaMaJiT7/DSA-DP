package LC_QUestion;

public class pangram_string {
//    public boolean checkIfPangram(String sentence) {
//        int n = sentence.length();
//        int[] chArr = new int[26];
//        for(int i = 0; i < n; i++){
//            int d = sentence.charAt(i) - 'a';
//            chArr[d]++;
//        }
//        for(int i = 0; i < chArr.length; i++){
//            if(chArr[i] == 0){
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean checkIfPangram(String sentence) {
        for(char ch = 'a'; ch <= 'z'; ch++){
            if(sentence.indexOf(ch) == -1){
                return false;
            }
        }
        return true;
    }
}
