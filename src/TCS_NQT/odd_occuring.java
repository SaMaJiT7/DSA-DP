package TCS_NQT;
import java.util.*;
import java.io.*;


public class odd_occuring {
    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int low = 0;
        int high = N-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(mid == 0 && (N== 1 || arr[0] != arr[1]) ){
                ans = arr[0];
                break;
            }
            if(mid == N-1 && arr[N-1] != arr[N-2]){
                ans = arr[N-1];
                break;
            }

            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                ans = arr[mid];
                break;
            }
            if((mid % 2 == 0 && arr[mid] == arr[mid+1]) || (mid % 2 != 0 && arr[mid] == arr[mid-1])){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        System.out.println("The Single odd occurence elemet is : " + ans);
    }
}
