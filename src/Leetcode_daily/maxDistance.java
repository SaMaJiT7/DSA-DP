package Leetcode_daily;

public class maxDistance {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
//        int i = 0;
//        int j = 0;
//        int ans = 0;
//        while(i < n && j < m){
//            if(nums1[i] <= nums2[j]){
//                ans = Math.max(ans,j-i);
//                j++;
//            }
//            else{
//                i++;
//            }
//        }
//        return ans;
        int result = 0;
        for(int i = 0; i < n; i++){
            int j = find(nums2,i,nums1[i]);

            if(j == -1) continue;

            result = Math.max(result,j-i);
        }
        return result;
    }
    public int find(int[] nums,int i,int target){
        int start = i;
        int end = nums.length-1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] >= target){
                ans = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return ans;
    }
}
