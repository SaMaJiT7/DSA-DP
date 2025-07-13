package ALGo_In_Array;

import java.util.Scanner;

public class StringB {
    public static void main(String[] args) {
//        StringBuilder builder = new StringBuilder();
//        for(int i = 0; i < 26; i++){
//            char ch = (char)('a' + i);
//            builder.append(ch);
//        }
//        builder.replace(0,5,"aaaaa");
//        builder.reverse();
//        System.out.println(builder);
//        String name = "Samajit Nandi";
//        System.out.println(name.toLowerCase());
//        System.out.println(name.strip());
//        System.out.println(Arrays.toString(name.split(" ")));
//        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println("Enter a String you want to check whether palindrome or not..");
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        a = a.toLowerCase();
        for(int i =0; i < (a.length()/2);i++) {
            char start = a.charAt(i);
            char end = a.charAt(a.length() - 1 - i);

            if(a == null || a.length() == 0){
                System.out.println("Invalid");
            }

            if (start == end) {
                System.out.println("It is Palindrome");
                break;
            } else {
                System.out.println("It is not Palindrome");
            }
        }
    }
}
