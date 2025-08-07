package Sliding_Window;

import java.util.ArrayList;

public class first_negative {
    public static void main(String[] args) {
        int[] arr = {12,-1,-7,8,-15,30,13,28};
        ArrayList<Integer> result = first_neg(arr,3);
        System.out.println(result);
    }


    public static ArrayList<Integer> first_neg(int[] arr, int k){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int i = 0;
        int j = 0;

        while(j < n){
            if(arr[j] < 0){
                list.add(arr[j]);
            }

        if(j-i+1 < k){
            j++;
        }
        else if(j-i+1 == k){
            if(list.isEmpty()){
                ans.add(0);
            }
            else {
                ans.add(list.get(0));
                }
            if(arr[i] < 0 && !list.isEmpty()){
                list.remove(0);
            }

            i++;
            j++;
            }
        }
        return ans;
    }
}
