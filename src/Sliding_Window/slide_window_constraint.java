package Sliding_Window;

public class slide_window_constraint {
    public int maxSubarrSum(int[] arr, int a, int b) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int maxsum = Integer.MIN_VALUE;
        while(j < n){
            sum = sum + arr[j];
            int len = j - i + 1;
            if(len < a){
                j++;
            }
            else if(len >= a && len <= b){
                maxsum = Math.max(sum,maxsum);
                int tempSum = sum;
                int tempI = i;
                int tempLen = len;

                while (tempLen > a) {
                    tempSum -= arr[tempI];
                    tempI++;
                    tempLen--;
                    maxsum = Math.max(maxsum, tempSum);
                }

                j++;
            }
            else if(len > b){
                sum = sum - arr[i];
                i++;
            }
        }
        return maxsum;
    }
}
