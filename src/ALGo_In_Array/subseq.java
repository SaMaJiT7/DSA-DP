package ALGo_In_Array;

import java.util.ArrayList;

public class subseq {
    public static void main(String[] args) {
        String str = "";
        String str1 = "abc";
        //Subseq(str,str1);
        System.out.println(Subseq1(str,str1));
    }
    public static void Subseq(String p , String up){   /// p represent processed string and up represent unprocessed string
        if(up.isEmpty()){
            System.out.printf("["+p+"]");;
            return;
        }

        char ch = up.charAt(0);

        Subseq(p + ch ,up.substring(1));
        Subseq(p,up.substring(1));
    }

    public static ArrayList<String> Subseq1(String p , String up){   /// p represent processed string and up represent unprocessed string
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = Subseq1(p + ch ,up.substring(1));
        ArrayList<String> right = Subseq1(p,up.substring(1));

        right.addAll(left);
        return right;
    }
}
