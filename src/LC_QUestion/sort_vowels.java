package LC_QUestion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class sort_vowels {
    public String sortVowels(String s) {
        HashSet<Character> vowels = new HashSet<>();
        StringBuilder t = new StringBuilder();
        char[] vowelChars = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        for (char vowel : vowelChars) {
            vowels.add(vowel);
        }

        List<Character> vowelList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                vowelList.add(c);
            }
        }
        // Convert to char array and sort using counting sort
        char[] vowelArr = new char[vowelList.size()];
        for (int i = 0; i < vowelList.size(); i++) {
            vowelArr[i] = vowelList.get(i);
        }
        sort1(vowelArr);

        int vowelIndex = 0;
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                t.append(vowelArr[vowelIndex++]);
            } else {
               t.append(c);
            }
        }
        return t.toString();
    }
        static void sort1(char[] arr) {
        if (arr.length == 0) return;

        // Fixed range for ASCII characters (0-255)
        int range = 256;
        int[] count = new int[range];

        // Count frequency of each character
        for (char c : arr) {
            count[c]++;
        }

        // Compute prefix sums (cumulative counts)
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array (stable sort)
        char[] output = new char[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy back to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}

