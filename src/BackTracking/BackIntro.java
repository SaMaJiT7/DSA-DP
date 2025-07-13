package BackTracking;

import java.util.ArrayList;

public class BackIntro {
    public static void main(String[] args) {
        System.out.println(Allpath1("",3,3));
    }
    public static void Allpath(String p , int r , int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (r > 1) {
            Allpath(p + "D", r - 1, c);
        }
        if (c > 1) {
            Allpath(p + "R", r, c - 1);
        }
        if (r > 0) {
            Allpath(p + "U", r - 1, c);
        }
        if (c > 0) {
            Allpath(p + "L", r, c - 1);
        }
    }
        public static ArrayList<String> Allpath1(String p , int r , int c) {
            if (r == 1 && c == 1) {
                ArrayList<String> list = new ArrayList<>();
                list.add(p);
                return list;
            }
            ArrayList<String> list = new ArrayList<>();
            if (r > 1) {
                list.addAll(Allpath1(p + "D", r - 1, c));
            }
            if (c > 1) {
                list.addAll(Allpath1(p + "R", r, c - 1));
            }
            if (r > 0) {
                list.addAll(Allpath1(p + "U", r - 1, c));
            }
            if (c > 0) {
                list.addAll(Allpath1(p + "L", r, c - 1));
            }
            return list;
        }

}
