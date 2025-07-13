package ALGo_In_Array;

public class setmismatch {
    public static void main(String[] args) {

    }
    static int[] finderrornums(int[] nums){
        int i = 0;
        int end = nums.length - 1;
        while (i <= end) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
            for (int index = 0; index < nums.length; index++) {
                if (nums[index] != index + 1) {
                    return new int[]{nums[index], index + 1};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
