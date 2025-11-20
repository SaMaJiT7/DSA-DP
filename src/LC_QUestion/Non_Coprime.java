package LC_QUestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Non_Coprime {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            ans.add(num);

            while (ans.size() >= 2) {
                int a = ans.get(ans.size() - 1);
                int b = ans.get(ans.size() - 2);
                int gcd = GCD(b, a);

                if (gcd <= 1) {
                    break;
                }
                long lcm = ((long) a * b) / gcd;
                ans.remove(ans.size() - 1);
                ans.remove(ans.size() - 1



























































































                );
                ans.add((int) lcm);
            }
        }
        return ans;
    }
//        int i = 0;
//            while (i < ans.size()-1) {
//                int a = ans.get(i);
//                int b = ans.get(i + 1);
//                if(GCD(a, b) > 1) {
//                    long lcm = ((long)a * b) / (GCD(a, b));
//                    ans.remove(i+1);
//                    ans.set(i, (int)lcm);
//                    i = Math.max(0,i-1);
//                }
//                else{
//                    i++;
//            }
//        }
//        return ans;
//
//    }
    static int GCD(int a , int b){
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }
}
