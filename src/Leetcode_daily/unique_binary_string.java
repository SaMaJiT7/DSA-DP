package Leetcode_daily;

import jdk.incubator.vector.VectorOperators;

import java.util.Arrays;

public class unique_binary_string {
//    public String findDifferentBinaryString(String[] nums) {
//        int n = nums.length;
//        int length = 1 << n;
//        int[] check = new int[length];
//        Arrays.fill(check,0);
//        for(int i = 0; i < n; i++){
//            String s = nums[i];
//            int val =0;
//            for(char ch : s.toCharArray()){
//                val = (val << 1) + (ch - '0');
//            }
//            check[val]++;
//        }
//
//        for(int i = 0; i <= n; i++){
//            if(check[i] == 0){
//                String binary = Integer.toBinaryString(i);
//                StringBuilder ans = new StringBuilder(binary);
//                while (ans.length() < n) ans.insert(0,'0');
//                return ans.toString();
//            }
//        }
//        return "";
//    }

    public String findDifferentBinaryString(String[] nums){
        StringBuilder ans = new StringBuilder();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int digit = nums[i].charAt(i) - '0';
            ans.append((digit == 0 ) ? '1' : '0');
        }
        return ans.toString();
    }
}
