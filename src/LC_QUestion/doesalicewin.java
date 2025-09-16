package LC_QUestion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class doesalicewin {
    public boolean doesAliceWin(String s) {
        HashSet<Character> vowels = new HashSet<>();
        char[] vowelChars = {'a', 'e', 'i', 'o', 'u'};

        for (char vowel : vowelChars) {
            vowels.add(vowel);
        }

        if (s.isEmpty()) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                return true;
            }
        }

        return false;
    }
}
