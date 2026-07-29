package TCS_NQT;

import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q1 {
    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        int[] b = new int[m];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st2.nextToken());
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            b[i] = Integer.parseInt(st3.nextToken());
        }

        HashSet<Integer> map = new HashSet<>();
        for(int i = 0; i < n; i++){
            map.add(a[i]);
        }
        for(int i = 0; i < m; i++){
            map.add(b[i]);
        }

        out.print(map.size());

        out.flush();
    }
}
