package TCS_NQT;

import java.io.*;
import java.util.Arrays;

public class digit_vault {
    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
//        String s = br.readLine();
//        if(s.isEmpty()){
//            out.print(-1);
//            return;
//        }
//        if(s.length() == 1){
//            out.println(s.charAt(0)-'0' >= 0 ? s.charAt(0)-'0' : -1);
//            return;
//        }
//        int ans = s.charAt(0)-'0';
//        for(int i = 1; i < s.length(); i+=2){
//            char op = s.charAt(i);
//            int nextdigit = s.charAt(i+1)-'0';
//
//            if(op == 'A'){
//                ans &= nextdigit;
//            }
//            else if(op == 'B'){
//                ans |= nextdigit;
//            }
//            else if(op == 'C'){
//                ans ^= nextdigit;
//            }
//        }
//        out.println(ans);
        int[] isprime = new int[1000001];
        Arrays.fill(isprime,1);
        isprime[0] = 0;
        isprime[1] = 1;
        for(int i = 2; i * i < 100001; i++){
            if(isprime[i] == 1){
                for(int j = i * i ; j < 100001; j +=i){
                    isprime[j] = 0;
                }
            }
        }
        int n = Integer.parseInt(br.readLine());
        out.println(isprime[n] == 1 ? 1 : 0);
        out.flush();
    }
}
