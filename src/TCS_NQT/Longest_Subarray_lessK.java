package TCS_NQT;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Longest_Subarray_lessK {
//    public int longestSubarray(int[] nums, int limit) {
//        int n = nums.length;
//        PriorityQueue<int[]> min = new PriorityQueue<>();
//        PriorityQueue<int[]> max = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));
//        int left = 0;
//        int right = 0;
//        int longestsubarray = 0;
//        while(right < n){
//            min.add(new int[]{nums[right],right}); //Storing like {Element,Idx} here the minimum element at the window.
//            max.add(new int[]{nums[right],right}); //Storing like {Element,Idx} here the maximum element at the window.
//
//            while(true){
//                while(!min.isEmpty() && min.peek()[1] < left){
//                    min.poll();
//                }
//                while(!max.isEmpty() && max.peek()[1] < left){
//                    max.poll();
//                }
//
//                int MaxE = max.isEmpty() ? 0 : max.peek()[0];
//                int MinE = min.isEmpty() ? 0 : min.peek()[0];
//
//                if(MaxE - MinE <= limit){
//                    break;
//                }
//                left++;
//            }
//            longestsubarray = Math.max(longestsubarray,right-left+1);
//            right++;
//        }
//        return longestsubarray;
//    }

    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();
        int ans = 0;
        int left = 0;
        int right = 0;
        while(right < n){
           while(!min.isEmpty() && nums[right] < min.peekLast()){
               min.pollLast();
           }
           min.add(nums[right]);
           while(!max.isEmpty() && nums[right] > max.peekLast()){
               max.pollLast();
           }
           max.add(nums[right]);



           while(max.peekFirst() - min.peekFirst() > limit){

               if(!min.isEmpty() && nums[left] == min.peekFirst()){
                   min.pollFirst();
               }
               if(!max.isEmpty() && nums[left] == max.peekFirst()){
                   max.pollFirst();
               }
               left++;
           }

           ans = Math.max(ans,right-left+1);
           right++;
        }
        return ans;
    }
}
