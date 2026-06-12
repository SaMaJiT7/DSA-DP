package Leetcode_daily;

public class ROTATE_STRING {
    public boolean rotateString(String s, String goal) {
//        if(s.equals(goal)){
//            return true;
//        }
//        if(s.length() != goal.length()) return false;
//        int n = s.length();
//        String ns = s + s;
//        int newn = ns.length();
//        StringBuilder check = new StringBuilder();
//        int j = 0;
//        while(j < newn){
//            check.append(ns.charAt(j));
//            if(check.length() > n){
//                check.deleteCharAt(0);
//            }
//            if(check.length() == n){
//                if(goal.contentEquals(check)){
//                    return true;
//                }
//            }
//            j++;
//        }
//        return false;
        if(s.length() != goal.length()) return false;
        s = s + s;
        if(s.contains(goal)) return true;
        return false;
    }
}
