package permutation;

import java.util.ArrayList;
import java.util.List;

public class Questions {
    public static void main(String[] args) {
        System.out.println(pad("","56"));
       // pad("","72");
    }
//    static void pad(String p , String up){
//        if (up.isEmpty()){
//            System.out.println(p);
//            return;
//        }
//        int digit  = (up.charAt(0)) - '0';
//        if(digit == 7) {
//            for (int i = (digit - 2) * 3; i <= (digit - 1) * 3; i++) {
//
//                char ch = (char) ('a' + i);
//                pad(p + ch, up.substring(1));
//            }
//        }
//         else if(digit == 9){
//                for(int i = (digit-2)*3 + 1; i < (digit-1)*3 + 1; i++){
//
//                    char ch = (char) ('a' + i);
//                    pad(p + ch , up.substring(1));
//                }
//
//        }
//         else {
//            for (int i = (digit - 1) * 3; i < digit * 3; i++) {
//
//                char ch = (char) ('a' + i - 3);
//                pad(p + ch, up.substring(1));
//            }
//        }
//    }
//    static int pad1(String p , String up){
//        if (up.isEmpty()){
//            return 1;
//        }
//        int digit  = (up.charAt(0)) - '0';
//        int count = 0;
//        if(digit == 7) {
//            for (int i = (digit - 2) * 3; i <= (digit - 1) * 3; i++) {
//
//                char ch = (char) ('a' + i);
//               count = count + pad1(p + ch, up.substring(1));
//            }
//        }
//        else if(digit == 9){
//            for(int i = (digit-2)*3 + 1; i < (digit-1)*3 + 1; i++){
//
//                char ch = (char) ('a' + i);
//               count = count + pad1(p + ch , up.substring(1));
//            }
//
//        }
//        else {
//            for (int i = (digit - 1) * 3; i < digit * 3; i++) {
//
//                char ch = (char) ('a' + i - 3);
//               count = count + pad1(p + ch, up.substring(1));
//            }
//        }
//        return count;
//    }
static List<String> pad(String p , String up) {
    if (up.isEmpty()) {
        List<String> list = new ArrayList<>();
        list.add(p);
        return list;
    }
    int digit = (up.charAt(0)) - '0';
    List<String> ans = new ArrayList<>();
    if (digit == 7) {
        for (int i = (digit - 2) * 3; i <= (digit - 1) * 3; i++) {

            char ch = (char) ('a' + i);
            ans.addAll(pad(p + ch, up.substring(1)));
        }
    } else if (digit == 9) {
        for (int i = (digit - 2) * 3 + 1; i < (digit - 1) * 3 + 1; i++) {

            char ch = (char) ('a' + i);
            ans.addAll(pad(p + ch, up.substring(1)));
        }

    } else {
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {

            char ch = (char) ('a' + i - 3);
            ans.addAll(pad(p + ch, up.substring(1)));
          }
       }
    return ans;
    }
}
