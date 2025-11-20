package LC_QUestion;

public class same_number_after_operation {
    public boolean hasSameDigits(String s) {
        if (s == null || s.length() < 2) {
            return false; // or throw exception if needed
        }

        int n = s.length();
        while (n > 2) {
            StringBuilder s1 = new StringBuilder();
            for (int i = 0; i < n - 1; i++) {
                int first = s.charAt(i) - '0';
                int second = s.charAt(i + 1) - '0';
                int value = (first + second) % 10;
                s1.append(value);
            }
            s = s1.toString();
            n = s.length();
        }
        return s.charAt(0) == s.charAt(1);
    }
}
