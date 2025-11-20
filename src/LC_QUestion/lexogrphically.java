package LC_QUestion;

public class lexogrphically {
    public String lexSmallest(String s) {
        int n = s.length();
        StringBuilder z = new StringBuilder();
        for(int i = 0; i < n; i++){
            z.append('z');
        }
        String min_str = z.toString();

        for (int k = 1; k <= n; k++) {


            String t1 = s.substring(0, k);
            StringBuilder sb1 = new StringBuilder(t1);
            sb1.reverse();
            String newStr1 = sb1 + s.substring(k);

            if (newStr1.compareTo(min_str) < 0) {
                min_str = newStr1;
            }


            if (k <= n) {
                String t2 = s.substring(n - k);
                StringBuilder sb2 = new StringBuilder(t2);
                sb2.reverse();
                String newStr2 = s.substring(0, n - k) + sb2;

                if (newStr2.compareTo(min_str) < 0) {
                    min_str = newStr2;
                }
            }
        }
        return min_str;
    }
}
