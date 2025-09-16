package Sliding_Window;

public class same_3largest {
    public String largestGoodInteger(String num) {
        int n = num.length();
        int i = 0;
        int j = 0;
        int k = 3;
        char maxdigit = '\0';

        while(j < n) {

            if (j - i + 1 < k) {
                j++;
            }
            else if (j - i + 1 == k) {
                if (num.charAt(i) == num.charAt(i + 1) &&
                        num.charAt(i) == num.charAt(i + 2)) {
                    maxdigit = (char) Math.max(maxdigit, num.charAt(i));
                }
                i++;
                j++;
            }
        }
        return maxdigit == '\0' ? "" : String.valueOf(maxdigit).repeat(3);
    }
}
