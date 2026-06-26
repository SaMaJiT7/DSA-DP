package Leetcode_daily;

public class median_two_array {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;
        while(low <= high){
            int px = low + (high - low) / 2; // this means the number of elements we have to take from the nums1
            int py = (m+n+1)/2 - px; // this means no of elements taken from nums2

            // Left half of the array
            int x1 = (px == 0) ? Integer.MIN_VALUE : nums1[px-1];
            int x2 = (py == 0) ? Integer.MIN_VALUE : nums2[py-1];
            // Right half of the array
            int x3 = (px == m) ? Integer.MAX_VALUE : nums1[px];
            int x4 = (py == n) ? Integer.MAX_VALUE : nums2[py];

            if(x1 <= x4 && x2 <= x3){
                if((m+n) % 2 == 1){
                    return Math.max(x1,x2);
                }
                return (double) (Math.max(x1, x2) + Math.min(x3, x4)) / 2;
            }
            if(x1 > x4){
                high = px - 1;
            }
            else{
                low = px + 1;
            }
        }
        return -1;
    }
}
