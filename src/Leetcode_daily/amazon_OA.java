package Leetcode_daily;

import java.util.Arrays;
import java.util.Scanner;

public class amazon_OA {
    static int[] isprime = new int[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        Arrays.fill(isprime,1);

        isprime[0] = 0;
        isprime[1] = 0;
        for(int i = 2; i*i <= 100001; i++){
            if(isprime[i] == 1){
                for(int j = i*i; j < 100001; j+=i){
                    isprime[j] = 0;
                }
            }
        }
        // abdjfdkcdef
        // abcfghlrstz

        String ans = Solution(s1,s2);

        System.out.println(ans);
    }
    public static String Solution(String s1,String s2){
        StringBuilder s = new StringBuilder();
        int n = s1.length();
        int m = s2.length();

        char lastseenprime = '\0';

        for(int i = 0 ; i < n; i++){
            int onebasedIndex = i + 1;
            if(onebasedIndex <= m && isprime[onebasedIndex] == 1){
                lastseenprime = s2.charAt(i);
            }
            if(isprime[onebasedIndex] == 1){
                if(lastseenprime != '\0'){
                    s.append(lastseenprime);
                }
                else{
                    s.append(s1.charAt(i));
                }
            }else{
                s.append(s1.charAt(i));
            }
        }

        return s.toString();
    }
}
