package LC_QUestion;

public class split_the_array {
    public static void main(String[] args) {

    }

    static int splitArray(int[] nums,int m){
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length ; i++) {
            start = Math.max(start,nums[i]);
            end = end + nums[i];
        }

        //Binary search

        while(start < end){
            int mid =  start + (end-start)/2;

            //calculator how many pieces we can divide it

            int sum=0;
            int pieces = 1;

            for(int num : nums){
                if(sum + num > mid){

                    sum = num;
                    pieces++;
                }
                else {
                    sum = num + sum;
                }
            }
            if(pieces <= mid){
                end = mid;
            }
            else {
                start = mid + 1;
            }

        }
        return end;
    }
}
