package ALGo_In_Array;

import java.util.ArrayList;
import java.util.List;

public class allthenumbers {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(allmissingnum(arr));
    }
    static List<Integer> allmissingnum(int[] arr){
        int i = 0;
        int end = arr.length - 1;
        while (i <= end) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }
            else {
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int index = 0;index < arr.length ; index++){
            if(arr[index] != index+1){
               ans.add(index + 1);
            }
        }
        return ans;
    }
}
