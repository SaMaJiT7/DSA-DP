package number_theory;

import java.util.Scanner;

public class almost_prime {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        int n = Sc.nextInt();
        int ans = 0;
        for(int i = 2; i <= n; i++){
            int cnt = 0;
            int num = i;
            for(int j = 2; j*j <= num; j++){
                if(num % j == 0){
                    cnt++;
                    while(num % j == 0){
                        num /= j;
                    }
                }
            }
            if(num > 1){
                cnt++;
            }
            if(cnt == 2){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
