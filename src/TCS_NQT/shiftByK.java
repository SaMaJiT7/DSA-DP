package TCS_NQT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/// N = 5 K = 2
/// INPUT = 1 2 3 4 5
/// OUTPUT = 3 4 5 1 2

public class shiftByK {
    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringTokenizer sn = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(sn.nextToken());
        }

        K = K % N;
        reverseNums(arr,0,K-1);
        reverseNums(arr,K,N-1);
        reverseNums(arr,0,N-1);

        for(int i = 0; i < N; i++){
            System.out.println(arr[i]);
        }
    }
    public static void reverseNums(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
