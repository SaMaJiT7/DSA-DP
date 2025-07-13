package ALGo_In_Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class linearsearchRecursion {
    public static void main(String[] args) {
        int[] arr = {10,50,16,49,20,10,40,20,10};
        int target = 10;
       ArrayList<Integer> ans = LSRecallindex1(arr,target,0);
        System.out.println(ans);
    }
//    public static int LSRec(int[] arr , int target,int i){
//        if(i > arr.length-1){
//            return -1;
//        }
//        if (arr[i] == target){
//            return i;
//        }
//        else {
//            return LSRec(arr,target,i+1);
//        }
//
//        public static boolean LSRec1(int[] arr , int target,int i){
//            if(i > arr.length-1){
//                return false;
//            }
//            return  (arr[i] == target) || LSRec1(arr,target,i+1);
//    }

//    public static int LSRecfromlast(int[] arr , int target,int i) {
//        if (i < 0) {
//            return -1;
//        }
//        if (arr[i] == target) {
//            return i;
//        } else {
//            return LSRecfromlast(arr, target, i-1);
//        }


   // ArrayList<Integer> List = new ArrayList<>();
   static ArrayList<Integer> List1 = new ArrayList<>();
        static ArrayList<Integer> LSRecallindex(int[] arr , int target,int i,ArrayList<Integer> List1) {
            if (i > arr.length - 1) {
                return List1;
            }
            if (arr[i] == target) {
                List1.add(i);
            }
            return LSRecallindex(arr, target, i + 1, List1);
        }

            static ArrayList<Integer> LSRecallindex1(int[] arr , int target,int i) {
            ArrayList<Integer> list = new ArrayList<>();
                if (i > arr.length-1) {
                    return list;
                }
                if (arr[i] == target) {
                    list.add(i);
                }
                ArrayList<Integer> answerfrombelowcalls = LSRecallindex1(arr, target, i+1);
                list.addAll(answerfrombelowcalls);

                return list;
        }
}
