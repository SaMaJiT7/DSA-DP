package ALGo_In_Array;

public class FirstMissingPositive {
    public static void main(String[] args) {

    }
    static int findpositivemisssing(int[] nums){
    int i = 0;
    int end = nums.length - 1;
        while (i <= end) {
            int correct = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }
        return nums.length + 1;
}
}
