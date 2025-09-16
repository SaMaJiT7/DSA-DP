package Greedy;

public class minimum_Teaching {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m  = nums1.length;
        int n = nums2.length;
        double ans = 0;
        int mid = 0;
        int[] newarr = new int[m+n];
        int len = newarr.length;
        int i = 0; int j = 0; int k = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                newarr[k++] = nums1[i++];
            } else {
                newarr[k++] = nums2[j++];
            }
        }

        // Append remaining from nums1
        while (i < m) {
            newarr[k++] = nums1[i++];
        }

        // Append remaining from nums2
        while (j < n) {
            newarr[k++] = nums2[j++];
        }
        if(len % 2 == 0){
            mid = binarysearch(newarr);
            ans = (double)(newarr[mid] + newarr[mid+1]) / 2;
            return ans;
        }else{
            mid = binarysearch(newarr);
            ans = (double) (newarr[mid]/2);
            return ans;
        }

    }
    static int binarysearch(int[] arr){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;

        while(low <= high){
             mid = low + (high-low)/2;
        }
        return mid;
    }
}
