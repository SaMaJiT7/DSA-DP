package number_theory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class primefactors {
    public static final int N = (int) 1e7;
    static int prime[] = new int[N];
    static int spf[] = new int[N];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solve(n);

//        int n = sc.nextInt();
//        List<Integer> fact = new ArrayList<>();
//
//        for(int i = 1; i*i <= n; i++){
//
//            if(n % i == 0){
//                fact.add(i);
//                if(i != n/i){
//                    fact.add(n/i);
//                }
//            }
//        }

//        int n = sc.nextInt();
//        List<Integer> ans = new ArrayList<>();
//        for(int i = 2; i * i <= n; i++){
//            if(n % i == 0) {
//                while (n % i == 0) {
//                    n /= i;
//                    ans.add(i);
//                }
//            }
//        }
//        if(n > 1){
//            ans.add(n);
//        }
        for(int i = 0; i < N; i++){
            prime[i] = 1;
        }
        prime[0] = 0;
        prime[1] = 0;
        for(int i = 2; i * i <= N;i++){
            if(prime[i] == 1){
                for(int j = i*i; j < N; j += i){
                    prime[j] = 0;
                }
            }
        }


        for(int i = 0; i < N; i++){
            spf[i] = i;
        }

        for(int i = 2; i < N; i++){
            if(spf[i] == i){
                for(int j = i*i; j < N; j += i){
                    if (spf[j] == j) { // only set if not already marked
                        spf[j] = i;
                    }
                }
            }
        }

    }
    public static int solve(int m){
        int n = m;
        List<Integer> prime_fact = new ArrayList<>();

        while(n > 1){
            prime_fact.add(spf[n]);
            n /= spf[n];
        }
        return 0;
    }
}
