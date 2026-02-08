package binary_search;

public class smaller_letter_greater {
    public char nextGreatestLetter(char[] letters, char target) {
        for(char ch : letters){
            if(ch > target){
                return ch;
            }
        }
        return letters[0];
    }
}
