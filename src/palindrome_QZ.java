import java.util.Scanner;

public class palindrome_QZ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number to check whether it is a palindrome num or not...");
        int Input = in.nextInt();
        palindrome(Input);
    }
    static void palindrome(int a){
        int num = a;
        int d;
        int rev = 0;
        while(num > 0) {
            d = num % 10;
            num = num / 10;
            rev = rev * 10 + d;
        }
            if (rev == a) {
                System.out.println("It is a Palindrome Number");
            } else {
                System.out.println("It is not a Palindrome Number.");
            }
    }
}
