package prefix_sum;

public class three_subarrays {
    private static final int mod = 1000000007;
    public int waysToSplit(int[] nums) {
        int n = nums.length;;
        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];

        for(int i = 1; i < prefix.length; i++){
           prefix[i] = prefix[i-1] + nums[i];
        }
        long count  = 0;

        for(int i = 0; i < n-2;i++){
            int sumLeft = prefix[i];

        int leftJ = findLeftJ(prefix, i + 1, sumLeft, prefix[n - 1]);

        // Binary search for rightmost j where sumMid <= sumRight
        int rightJ = findRightJ(prefix, i + 1, sumLeft, prefix[n - 1]);

        if (leftJ <= rightJ && leftJ != -1) {
            count = (count + (rightJ - leftJ + 1)) % mod;
        }
    }
        return (int) count;
}

    private int findLeftJ(int[] prefix, int start, int sumLeft, int total) {
        int low = start;
        int high = prefix.length - 2;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sumMid = prefix[mid] - prefix[start - 1];
            int sumRight = total - prefix[mid];
            if (sumMid >= sumLeft && sumRight >= sumMid) {
                result = mid;
                high = mid - 1;
            } else if (sumMid < sumLeft) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private int findRightJ(int[] prefix,int start,int sumLeft, int total){
        int n = prefix.length;
        int low = start;
        int high = prefix.length - 2;
        int result = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int sumMid = prefix[mid] - prefix[start-1];
            int sumRight = prefix[n-1] - prefix[mid];

            if(sumMid <= sumRight && sumMid >= sumLeft){
                result = mid;
                low = mid + 1;
            }
            else if(sumMid > sumRight){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return result;
    }
}
