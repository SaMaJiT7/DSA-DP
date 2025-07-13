public class LeetCode_CeilingQs {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        System.out.println(nextGreatestLetter(letters,'f'));
    }
   static public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
//        if(start == letters.length){
//           return letters[0];
//       }

        while (start <= end) {
            int Mid = start + (end - start)/2;

            if (letters[Mid] > target) {
                end = Mid - 1;
            }
            else if (letters[Mid] < target) {
                start = Mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}
