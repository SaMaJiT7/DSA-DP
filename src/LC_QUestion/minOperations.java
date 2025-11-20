package LC_QUestion;

public class minOperations {
    public long minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int x = nums2[nums2.length-1];
        long ops = 0; int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            ops += Math.abs(nums1[i] - nums2[i]);
            int dist = Math.min(1+Math.abs(nums1[i]-x),1+Math.abs(nums2[i]-x));
            if(Math.min(nums1[i],nums2[i]) <= x && x <= Math.max(nums1[i],nums2[i])){
                dist = 1;
            }
            min = Math.min(min,dist);
        }
        ops += min;
        return ops;
    }
}
