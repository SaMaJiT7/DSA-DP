package Bit_manipulation;

import java.util.Scanner;

public class XOR_L_r {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int[] pre = new int[n];
        pre[0] = nums[0];
        for(int i = 1; i < n; i++){
            pre[i] = (pre[i-1] ^ nums[i]);
        }
        int q = sc.nextInt();
        while(q-- > 0){
            int l , r;
            l = sc.nextInt();
            r = sc.nextInt();
            l--;r--;
            System.out.println(pre[r] - (l==0 ? 0 : pre[l-1]));
        }
    }
}
