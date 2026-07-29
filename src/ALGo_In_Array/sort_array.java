package ALGo_In_Array;

public class sort_array {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mid = low + (high-low)/2;

        int[] l1 = sortHalf(nums,0,mid);
        int[] l2 = sortHalf(nums,mid+1,n-1);

        int[] ans = mergeArray(l1,l2);

        return ans;
    }
    public int[] sortHalf(int[] nums,int l, int r){
        if(l >= r){
            return new int[]{nums[l]};
        }
        int mid = l + (r-l)/2;
        int[] left = sortHalf(nums,l,mid);
        int[] right = sortHalf(nums,mid+1,r);

        int[] ans = mergeArray(left,right);

        return ans;
    }
    public int[] mergeArray(int[] left,int[] right){
        int n = left.length;
        int m = right.length;
        int[] ans = new int[n+m];

        int l1 = 0;
        int l2 = 0;
        int i = 0;
        while(l1 < n && l2 < m){
            if(left[l1] <= right[l2]){
                ans[i++] = left[l1];
                l1++;
            }
            else{
                ans[i++] = right[l2];
                l2++;
            }
        }
        while(l1 < n){
            ans[i++] = left[l1++];
        }
        while(l2 < m){
            ans[i++] = right[l2++];
        }
        return ans;
    }
}
