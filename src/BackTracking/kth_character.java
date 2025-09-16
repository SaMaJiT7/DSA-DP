package BackTracking;

public class kth_character {
    public char kthCharacter(int k) {
        char ans = helper(k, "a");
        return ans;
    }

    static char helper(int k, String word) {
        if (word.length() >= k) {
            return word.charAt(k - 1);
        }

        StringBuilder ans = new StringBuilder(word.length());
        for (char ch : word.toCharArray()) {
                // Shift with wrap-around
                char next = (char) ((ch - 'a' + 1) % 26 + 'a');
                ans.append(next);
        }
        String ans1 =  word + ans.toString();
        return helper(k, ans1);
    }
}
