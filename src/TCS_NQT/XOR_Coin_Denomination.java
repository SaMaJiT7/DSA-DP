package TCS_NQT;

import java.io.*;
import java.util.StringTokenizer;

public class XOR_Coin_Denomination {
//    static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
//        int n = Integer.parseInt(br.readLine().trim());
//
//        String input = br.readLine().trim();
//
//        String[] arr = input.split(" ");
//        int[] nums = new int[n];
//        for(int i = 0; i < n; i++){
//            nums[i] = Integer.parseInt(arr[i].trim());
//        }
//        int ans = 0;
//        for(int i = 0; i < n; i++){
//            ans = ans ^ nums[i];
//        }
//
//        out.print(ans);
//
//        out.flush();
//    }

    // input - Hello World TCS
    // output - olleH dlroW SCT
    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        String s = br.readLine();
        String[] words = s.split(" ");

        StringBuilder ans = new StringBuilder();
        for(String word : words){
//            int i = 0;
//            int j = word.length()-1;
//            char[] wordarr = word.toCharArray();
//            while(i < j) {
//                char temp = word.charAt(i);
//                wordarr[i] = wordarr[j];
//                wordarr[j] = temp;
//                i++;
//                j--;
//            }
            StringBuilder word1 = new StringBuilder(word).reverse();
            ans.append(word1).append(" ");
        }
        out.print(ans.toString());

        out.flush();
    }

}
