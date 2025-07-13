import java.util.Scanner;

public class cf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        boolean has4 = false;
        boolean has7 = false;

        int count = 0;
        while(n > 0){
            int digit = n % 10;
            count += 1;
            if(digit == 4){
                has4 = true;
            } else if (digit == 7) {
                has7 = true;
            }
            n = n / 10;
        }

        if(has4 && has7 && (count == 4 || count == 7)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

