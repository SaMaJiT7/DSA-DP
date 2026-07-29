package ALGo_In_Array;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class unique_k_pairs {
    static int mod = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] val = input.split(" ");
        int N = Integer.parseInt(val[0]);
        int k = Integer.parseInt(val[1]);
        String input2 = sc.nextLine();
        String[] arr = input2.split(" ");
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        long count = 0;
        for(int freq : map.values()){
            count = (count + calculate(freq,k)) % mod;
        }

        System.out.println(count);
    }
    public static long calculate(int n, int r){
        if(r > n){
            return 0;
        }
        if(r > n-r){
            r = n-r;
        }
        long result = 1;
        for(int i = 1; i <= r; i++){
            result = (result * (n-i+1)) % mod;
            result /= i;
        }

        return result;
    }
}
