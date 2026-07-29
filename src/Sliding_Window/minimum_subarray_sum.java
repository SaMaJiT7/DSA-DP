package Sliding_Window;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class minimum_subarray_sum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        int ans = minSubArrayLen(target,nums);
        out.println(ans);
        out.close();
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while(j < n){
            sum += nums[j];
            while(sum >= target){
                minLen = Math.min(minLen,j-i+1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
